package acuario.msvc.auth.auth.entity.client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

@Entity
@Table(name = "oauth2_registered_client")
public class Client {

  @Id
  @Column(length = 100, nullable = false)
  private String id;
  @Column(length = 100, nullable = false)
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

  public Client() {
  }

  public Client(RegisteredClient registeredClient) {
    this.id = registeredClient.getId();
    this.clientId = registeredClient.getClientId();
    this.clientIdIssuedAt = registeredClient.getClientIdIssuedAt();
    this.clientSecret = registeredClient.getClientSecret();
    this.clientSecretExpiresAt = registeredClient.getClientSecretExpiresAt();
    this.clientName = registeredClient.getClientName();
    if (!registeredClient.getClientAuthenticationMethods().isEmpty()) {
      this.clientAuthenticationMethods = registeredClient.getClientAuthenticationMethods().stream()
          .map(e -> e.getValue()).collect(Collectors.joining(","));
      this.clientAuthenticationMethods = this.clientAuthenticationMethods.substring(1,
          this.clientAuthenticationMethods.length() - 1);
    }
    if (!registeredClient.getAuthorizationGrantTypes().isEmpty()) {
      this.authorizationGrantTypes = registeredClient.getAuthorizationGrantTypes().stream()
          .map(e -> e.getValue()).collect(Collectors.joining(","));
      this.authorizationGrantTypes = this.authorizationGrantTypes.substring(1,
          this.authorizationGrantTypes.length() - 1);
    }
    if (!registeredClient.getRedirectUris().isEmpty()) {
      this.redirectUris = registeredClient.getRedirectUris().stream().collect(Collectors.joining(","));
      this.redirectUris = this.redirectUris.substring(1, this.redirectUris.length() - 1);
    }
    if (!registeredClient.getPostLogoutRedirectUris().isEmpty()) {
      this.postLogoutRedirectUris = registeredClient.getPostLogoutRedirectUris().stream()
          .collect(Collectors.joining(","));
      this.postLogoutRedirectUris = this.postLogoutRedirectUris.substring(1, this.postLogoutRedirectUris.length() - 1);
    }
    if (!registeredClient.getScopes().isEmpty()) {
      this.scopes = registeredClient.getScopes().stream().collect(Collectors.joining(","));
      this.scopes = this.scopes.substring(1, this.scopes.length() - 1);
    }
    this.tokenSettings = registeredClient.getTokenSettings().toString();
  }

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
