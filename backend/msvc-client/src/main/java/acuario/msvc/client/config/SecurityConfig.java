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

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
        requests -> requests
            .requestMatchers("/authorized").permitAll()
            .requestMatchers(HttpMethod.GET, "/list").hasAnyAuthority("SCOPE_read", "SCOPE_write")
            .requestMatchers(HttpMethod.POST, "/create").hasAuthority("SCOPE_write")
            .anyRequest().authenticated())
        .csrf(csrf -> csrf.disable())
        // La session sera manejada por el token
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .oauth2Login(login -> login.loginPage("/oauth2/authorization/client-app"))
        .oauth2Client(withDefaults())
        .oauth2ResourceServer(resourceServer -> resourceServer.jwt(withDefaults()));
    return http.build();
  }
}
