package acuario.msvc.auth.auth.entity.pk;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OAuth2AuthorizationConsentPk implements Serializable {

  @Column(length = 100, nullable = false)
  private String registeredClientId;

  @Column(length = 200, nullable = false)
  private String principalName;

  public OAuth2AuthorizationConsentPk() {
  }

  public OAuth2AuthorizationConsentPk(String registeredClientId, String principalName) {
    this.registeredClientId = registeredClientId;
    this.principalName = principalName;
  }

  @Override
  public int hashCode() {
    return registeredClientId.hashCode() + principalName.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OAuth2AuthorizationConsentPk otro = (OAuth2AuthorizationConsentPk) obj;
    if (registeredClientId == null || principalName == null)
      return false;
    else if (!registeredClientId.equals(otro.registeredClientId) || !principalName.equals(otro.principalName))
      return false;
    return true;
  }

  public String getRegisteredClientId() {
    return registeredClientId;
  }

  public void setRegisteredClientId(String registeredClientId) {
    this.registeredClientId = registeredClientId;
  }

  public String getPrincipalName() {
    return principalName;
  }

  public void setPrincipalName(String principalName) {
    this.principalName = principalName;
  }


  private static final long serialVersionUID = 1L;
}
