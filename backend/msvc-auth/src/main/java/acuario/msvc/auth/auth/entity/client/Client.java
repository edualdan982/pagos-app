package acuario.msvc.auth.auth.entity.client;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "oauth2_registered_client")
public class Client {

  @Id
  @Column(length = 100, columnDefinition = "varchar2(100)", nullable = false)
  private String id;
  @Column(length = 100, columnDefinition = "varchar2(100)", nullable = false)
  private String clientId;

  @Column(columnDefinition = "timestamp(6) DEFAULT CURRENT_TIMESTAMP", nullable = false)
  private Instant clientIdIssuedAt;
  @Column(length = 200, columnDefinition = "varchar2(200) default null")
  private String clientSecret;

  private Instant clientSecretExpiresAt;
  @Column(length = 200, nullable = false)
  private String clientName;
  @Column(length = 1000, nullable = false)
  private String clientAuthenticationMethods;
  @Column(length = 1000, nullable = false)
  private String authorizationGrantTypes;
  @Column(length = 1000, columnDefinition = "varchar2(1000) default null")
  private String redirectUris;
  @Column(length = 1000, columnDefinition = "varchar2(1000) default null")
  private String postLogoutRedirectUris;
  @Column(length = 1000, nullable = false)
  private String scopes;
  @Column(length = 2000, nullable = false)
  private String clientSettings;
  @Column(length = 2000, nullable = false)
  private String tokenSettings;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public Instant getClientIdIssuedAt() {
    return clientIdIssuedAt;
  }

  public void setClientIdIssuedAt(Instant clientIdIssuedAt) {
    this.clientIdIssuedAt = clientIdIssuedAt;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public Instant getClientSecretExpiresAt() {
    return clientSecretExpiresAt;
  }

  public void setClientSecretExpiresAt(Instant clientSecretExpiresAt) {
    this.clientSecretExpiresAt = clientSecretExpiresAt;
  }

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public String getClientAuthenticationMethods() {
    return clientAuthenticationMethods;
  }

  public void setClientAuthenticationMethods(String clientAuthenticationMethods) {
    this.clientAuthenticationMethods = clientAuthenticationMethods;
  }

  public String getAuthorizationGrantTypes() {
    return authorizationGrantTypes;
  }

  public void setAuthorizationGrantTypes(String authorizationGrantTypes) {
    this.authorizationGrantTypes = authorizationGrantTypes;
  }

  public String getRedirectUris() {
    return redirectUris;
  }

  public void setRedirectUris(String redirectUris) {
    this.redirectUris = redirectUris;
  }

  public String getPostLogoutRedirectUris() {
    return postLogoutRedirectUris;
  }

  public void setPostLogoutRedirectUris(String postLogoutRedirectUris) {
    this.postLogoutRedirectUris = postLogoutRedirectUris;
  }

  public String getScopes() {
    return scopes;
  }

  public void setScopes(String scopes) {
    this.scopes = scopes;
  }

  public String getClientSettings() {
    return clientSettings;
  }

  public void setClientSettings(String clientSettings) {
    this.clientSettings = clientSettings;
  }

  public String getTokenSettings() {
    return tokenSettings;
  }

  public void setTokenSettings(String tokenSettings) {
    this.tokenSettings = tokenSettings;
  }

}
