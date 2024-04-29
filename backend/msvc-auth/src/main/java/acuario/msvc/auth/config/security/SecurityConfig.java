package acuario.msvc.auth.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  // @Autowired
  // private UserDetailsService userDetailsService;

  @Bean
  public static BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // formater:off
  // @Bean
  // public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
  //     throws Exception {
  //   http
  //       .authorizeHttpRequests((authorize) -> authorize
  //           .anyRequest().authenticated())
  //       // Form login handles the redirect to the login page from the
  //       // authorization server filter chain
  //       .csrf(csrf -> csrf.disable())
  //       .formLogin(Customizer.withDefaults());

  //   return http.build();
  // }
  // formater:off
  
  // Este es para probar de forma local con UserDetailsManager en mememoria
    @Bean
    public UserDetailsService userDetailsService() {
    UserDetails userDetails = User.builder()
    .username("edual")
    .password("{noop}12346")
    .roles("USER")
    .build();
    
    return new InMemoryUserDetailsManager(userDetails);
    }

  // @Autowired
  // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  //   auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  // }
}
