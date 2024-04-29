package acuario.msvc.pagos.config.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class DataInitConfig implements IDataInitConfig {
  private static final Logger log = LoggerFactory.getLogger(DataInitConfig.class);

  private static final String SEQ_NOCACHE = "select sequence_owner,sequence_name from dba_sequences WHERE sequence_owner=?1 AND cache_size > 0";
  private static final String ALTER_NOCACHE = "alter sequence %s nocache";

  @PersistenceContext
  private EntityManager em;
  @Autowired
  private Environment env;

  @Value("${spring.datasource.username}")
  private String db_username;

  @Transactional
  @Override
  public Map<String, Object> verificarData() {
    Map<String, Object> result = new HashMap<>();
    List<String> res = new ArrayList<>();
    Query query = em.createNativeQuery(SEQ_NOCACHE);
    query.setParameter(1, db_username);

    @SuppressWarnings("unchecked")
    List<Object[]> listaSecuencias = query.getResultList();
    if (listaSecuencias.isEmpty()) {
      String auxMsg = "No se tiene secuencias con cache en la base de datos";
      result.put("mensaje", auxMsg);
      log.info(auxMsg);
      return result;
    }
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(env.getProperty("spring.datasource.url"),
          env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));

      Iterator<Object[]> it = listaSecuencias.iterator();
      Statement stmt = null;
      while (it.hasNext()) {
        Object[] obj = it.next();
        String seqName = String.format("%s.%s", obj[0], obj[1]);
        try {
          stmt = conn.createStatement();
          stmt.execute(String.format(ALTER_NOCACHE, seqName));
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
          log.error("No se pudo completar el proceso de la sentencia SQL.");
        }
    }

    result.put("respuesta", res);

    return result;
  }
}
