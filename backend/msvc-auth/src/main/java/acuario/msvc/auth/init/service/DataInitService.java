package acuario.msvc.auth.init.service;

import java.time.Duration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Service;

import acuario.msvc.auth.auth.entity.client.Client;
import acuario.msvc.auth.auth.repositories.ClientRepository;
import acuario.msvc.auth.init.TypeQuerys;

@Service
public class DataInitService implements IDataInitService {
  private static final Logger log = LoggerFactory.getLogger(DataInitService.class);

  @PersistenceContext
  private EntityManager em;
  @Value("${spring.datasource.username}")
  private String db_username;

  @Autowired
  private Environment env;
  @Autowired
  private ClientRepository clientRepository;

  @Override
  public Connection crearConexion(String url, String username, String password) {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url, username, password);

    } catch (Exception e) {
      log.error("Servicio-crearConexion: No se puede establar la conexión DDL.");
    }
    return conn;
  }

  @Override
  public Map<String, Object> verificarSecuencias() {
    Map<String, Object> result = new HashMap<>();
    List<String> res = new ArrayList<>();
    Query query = em.createNativeQuery(TypeQuerys.SEQ_NOCACHE.getQuery());
    query.setParameter(1, db_username != null ? db_username.toUpperCase() : "not_user");

    @SuppressWarnings("unchecked")
    List<Object[]> listaSecuencias = query.getResultList();
    if (listaSecuencias.isEmpty()) {
      String auxMsg = "No se tiene secuencias con cache en la base de datos";
      result.put("mensaje", auxMsg);
      log.info(auxMsg);
      return result;
    }
    Connection conn = this.crearConexion(env.getProperty("spring.datasource.url"),
        db_username, env.getProperty("spring.datasource.password"));
    try {
      Iterator<Object[]> it = listaSecuencias.iterator();
      Statement stmt = null;
      while (it.hasNext()) {
        Object[] obj = it.next();
        String seqName = String.format("%s.%s", obj[0], obj[1]);
        try {
          stmt = conn.createStatement();
          stmt.execute(String.format(TypeQuerys.ALTER_NOCACHE.getQuery(), seqName));
          res.add(seqName);
          log.info("Se ha alterado la secuencia: {}, para no tener un CACHE_SIZE.", seqName);
        } catch (Exception e) {
          log.error("No se pudo alterar la secuencia: {}. Detalle: {}", seqName,
              (e.getLocalizedMessage() == null ? e.getMessage() : e.getLocalizedMessage()));
          res.add(seqName);
        } finally {
          try {
            if (stmt != null)
              stmt.close();
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
      }
    } catch (Exception e) {
      log.error("No se puede establar la conexión DDL.");
      result.put("mensaje", "No se puede establar la conexión DDL.");
      return result;
    } finally {
      if (conn != null)
        try {
          conn.close();
        } catch (SQLException e) {
          log.error("No se pudo cerrar la conexion DDL.");
        }
    }

    result.put("respuesta", res);

    return result;
  }

  @Override
  public Map<String, Object> cargarClientesInit() {
    Map<String, Object> result = new HashMap<>();

    List<Client> registerClients = new ArrayList<>();

    String uuid = "mscv-client-default-0001";
    Client clientApp = new Client(RegisteredClient.withId(uuid)
        // ? Este es el identificador del cliente no confundir con el "clientName"
        .clientId("msvc-client-id")
        // Cuando hemos creado el usuario en la base de datos, hemos encriptado la
        // contraseña con BCryptPasswordEncoder
        .clientSecret("$2a$10$8/jOZCRJ7hnAb8reB3AasusguXNXhL6Dg..NdjtbwYRNet6ZysEDq")
        .tokenSettings(tokenSettings())
        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
        .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
        // ? Al final es donde se pone el "clientName" en esta caso es: 'msvc-client'
        .redirectUri("http://127.0.0.1:8091/login/oauth2/code/msvc-client")
        .redirectUri("http://127.0.0.1:8091/authorized")
        .postLogoutRedirectUri("http://127.0.0.1:8091/logout")
        .scope("read")
        .scope("write")
        .scope(OidcScopes.OPENID)
        .scope(OidcScopes.PROFILE)
        .clientSettings(ClientSettings.builder().requireAuthorizationConsent(false).build())
        .build());
    if (clientRepository.verificarClient(uuid))
      registerClients.add(clientApp);

    uuid = "mscv-pagos-default-0002";
    Client pagosApp = new Client(RegisteredClient.withId(uuid)
        .clientId("msvc-pagos-id")
        .clientSecret("{noop}123456")
        .tokenSettings(tokenSettings())
        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
        .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
        .redirectUri("http://127.0.0.1:8090/login/oauth2/code/msvc-pagos")
        .redirectUri("http://127.0.0.1:8090/authorized")
        .postLogoutRedirectUri("http://127.0.0.1:8090/logout")
        .scope("read")
        .scope("write")
        .scope(OidcScopes.OPENID)
        .scope(OidcScopes.PROFILE)
        .build());
    registerClients.add(pagosApp);
    if (clientRepository.verificarClient(uuid))
      registerClients.add(pagosApp);

    if (!registerClients.isEmpty()) {
      clientRepository.saveAll(registerClients);
      result.put("mensaje", "Se han registro los clientes.");
    }

    return result;
  }

  private TokenSettings tokenSettings() {
    return TokenSettings.builder()
        .accessTokenTimeToLive(Duration.ofDays(360L))
        .build();
  }

}
