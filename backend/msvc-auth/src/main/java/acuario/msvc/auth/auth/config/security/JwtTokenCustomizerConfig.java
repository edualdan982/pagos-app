package acuario.msvc.auth.auth.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;

// @Configuration
/*
 * Para agregar mas datos al token JWT
*/
public class JwtTokenCustomizerConfig {

  // @Bean
  public OAuth2TokenCustomizer<JwtEncodingContext> tokenCustomizer() {
    return (context) -> {
      if (OAuth2TokenType.ACCESS_TOKEN.equals(context.getTokenType())) {
        context.getClaims().claims((claims) -> {
          claims.put("claim-1", "value-1");
          claims.put("claim-2", "value-2");
        });
      }
    };
  }
}
