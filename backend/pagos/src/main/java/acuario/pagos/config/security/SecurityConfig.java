package acuario.pagos.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private static final String SCOPE_WRITE = "SCOPE_write";
  private static final String SCOPE_READ = "SCOPE_read";

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
        requests -> requests
            .requestMatchers("/authorized", "/info").permitAll()
            .requestMatchers("/pago/**").hasAnyAuthority(SCOPE_WRITE, SCOPE_READ)
            .anyRequest().authenticated())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .oauth2Login(login -> login.loginPage("/oauth2/authorization/pagos-client"))
        .oauth2Client(Customizer.withDefaults())
        .csrf(AbstractHttpConfigurer::disable)
        .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt(Customizer.withDefaults()));
    return http.build();
  }
}
