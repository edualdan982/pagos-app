package acuario.msvc.auth.auth.entity;

import acuario.msvc.auth.auth.entity.pk.OAuth2AuthorizationConsentPk;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "oauth2_authorization_consent")
public class OAuth2AuthorizationConsent {

  @EmbeddedId
  private OAuth2AuthorizationConsentPk pk;

  @Column(length = 1000)
  private String authorities;

  public OAuth2AuthorizationConsentPk getPk() {
    return pk;
  }

  public void setPk(OAuth2AuthorizationConsentPk pk) {
    this.pk = pk;
  }

  public String getAuthorities() {
    return authorities;
  }

  public void setAuthorities(String authorities) {
    this.authorities = authorities;
  }

}
