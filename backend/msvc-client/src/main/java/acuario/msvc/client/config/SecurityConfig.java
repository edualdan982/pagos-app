package acuario.msvc.client.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  private static final String SCOPE_WRITE = "SCOPE_write";
  private static final String SCOPE_READ = "SCOPE_read";

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
        requests -> requests
            .requestMatchers("/authorized").permitAll()
            .requestMatchers(HttpMethod.GET, "/list").permitAll()
            // .requestMatchers(HttpMethod.GET, "/list").hasAnyRole(SCOPE_WRITE, SCOPE_READ)
            .requestMatchers(HttpMethod.POST, "/create").hasAuthority(SCOPE_WRITE)
            .anyRequest().authenticated())
        .csrf(csrf -> csrf.disable())
        .cors(cors -> cors.disable())
        // La session sera manejada por el token
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .oauth2Login(login -> login.loginPage("/oauth2/authorization/msvc-client"))
        .oauth2Client(withDefaults())
        .oauth2ResourceServer(resourceServer -> resourceServer.jwt(withDefaults()));
    return http.build();
  }
}
