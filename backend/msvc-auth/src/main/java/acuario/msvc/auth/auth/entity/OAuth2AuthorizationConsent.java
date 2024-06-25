package acuario.msvc.auth.auth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table()
public class OAuth2AuthorizationConsent {
  
  

  @Column(length = 1000)
  private String authorities;
  
}
