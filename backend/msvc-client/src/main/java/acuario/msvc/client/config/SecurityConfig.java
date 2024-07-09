package acuario.msvc.client.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  private static final String SCOPE_WRITE = "SCOPE_write";
  private static final String SCOPE_READ = "SCOPE_read";

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
        requests -> requests
            .requestMatchers("/authorized").permitAll()
            .requestMatchers(HttpMethod.GET, "/list").hasAnyAuthority(SCOPE_WRITE, SCOPE_READ)
            .requestMatchers(HttpMethod.POST, "/create").hasAuthority(SCOPE_WRITE)
            .anyRequest().authenticated())
        .csrf(csrf -> csrf.disable())
        // .cors(cors -> cors.disable())
        // La session sera manejada por el token
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .oauth2Login(login -> login.loginPage("/oauth2/authorization/msvc-client"))
        .oauth2Client(withDefaults())
        .oauth2ResourceServer(resourceServer -> resourceServer.jwt(jwt -> jwt.decoder(jwtDecoder())));
    return http.build();
  }

  @Bean
  public JwtDecoder jwtDecoder() {
    return NimbusJwtDecoder.withJwkSetUri("http://127.0.0.1:9000/oauth2/jwks").jwsAlgorithm(SignatureAlgorithm.RS256)
        .build();
  }
}
