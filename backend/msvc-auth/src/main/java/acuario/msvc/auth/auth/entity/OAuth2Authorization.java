package acuario.msvc.auth.auth.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "oauth2_authorization")
public class OAuth2Authorization {
  @Id
  @Column(length = 100, nullable = false)
  private String id;

  @Column(length = 100, nullable = false)
  private String registeredClientId;

  @Column(length = 200, nullable = false)
  private String principalName;

  @Column(length = 100, nullable = false)
  private String authorizationGrantType;

  @Column(length = 1000, columnDefinition = "varchar2(1000) default null")
  private String authorizedScopes;

  @Column(columnDefinition = "CLOB default null")
  private String attributes;

  @Column(length = 500, columnDefinition = "varchar2(500) default null")
  private String state;

  @Column(columnDefinition = "CLOB default null")
  private String authorizationCodeValue;

  @Temporal(TemporalType.TIMESTAMP)
  private Date authorizationCodeIssuedAt;

  @Temporal(TemporalType.TIMESTAMP)
  private Date authorizationCodeExpiresAt;

  @Column(columnDefinition = "CLOB default null")
  private String authorizationCodeMetadata;

  @Column(columnDefinition = "CLOB default null")
  private String accessTokenValue;

  @Temporal(TemporalType.TIMESTAMP)
  private Date accessTokenIssuedAt;

  @Temporal(TemporalType.TIMESTAMP)
  private Date accessTokenExpiresAt;

  @Column(columnDefinition = "CLOB default null")
  private String accessTokenMetadata;

  @Column(length = 100, columnDefinition = "varchar2(100) default null")
  private String accessTokenType;

  @Column(length = 1000, columnDefinition = "varchar2(1000) default null")
  private String accessTokenScopes;

  @Column(columnDefinition = "CLOB default null")
  private String oidcIdTokenValue;

  @Temporal(TemporalType.TIMESTAMP)
  private Date oidcIdTokenIssuedAt;

  @Temporal(TemporalType.TIMESTAMP)
  private Date oidcIdTokenExpiresAt;

  @Column(columnDefinition = "CLOB default null")
  private String oidcIdTokenMetadata;

  @Column(columnDefinition = "CLOB default null")
  private String refreshTokenValue;

  @Temporal(TemporalType.TIMESTAMP)
  private Date refreshTokenIssuedAt;

  @Temporal(TemporalType.TIMESTAMP)
  private Date refreshTokenExpires_At;

  @Column(columnDefinition = "CLOB default null")
  private String refreshTokenMetadata;

  @Column(columnDefinition = "CLOB default null")
  private String userCodeValue;

  @Temporal(TemporalType.TIMESTAMP)
  private Date userCodeIssuedAt;

  @Temporal(TemporalType.TIMESTAMP)
  private Date userCodeExpiresAt;

  @Column(columnDefinition = "CLOB default null")
  private String userCodeMetadata;

  @Column(columnDefinition = "CLOB default null")
  private String deviceCodeValue;

  @Temporal(TemporalType.TIMESTAMP)
  private Date deviceCodeIssuedAt;
  @Temporal(TemporalType.TIMESTAMP)
  private Date deviceCodeExpiresAt;

  @Column(columnDefinition = "CLOB default null")
  private String deviceCodeMetadata;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getAuthorizationGrantType() {
    return authorizationGrantType;
  }

  public void setAuthorizationGrantType(String authorizationGrantType) {
    this.authorizationGrantType = authorizationGrantType;
  }

  public String getAuthorizedScopes() {
    return authorizedScopes;
  }

  public void setAuthorizedScopes(String authorizedScopes) {
    this.authorizedScopes = authorizedScopes;
  }

  public String getAttributes() {
    return attributes;
  }

  public void setAttributes(String attributes) {
    this.attributes = attributes;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getAuthorizationCodeValue() {
    return authorizationCodeValue;
  }

  public void setAuthorizationCodeValue(String authorizationCodeValue) {
    this.authorizationCodeValue = authorizationCodeValue;
  }

  public Date getAuthorizationCodeIssuedAt() {
    return authorizationCodeIssuedAt;
  }

  public void setAuthorizationCodeIssuedAt(Date authorizationCodeIssuedAt) {
    this.authorizationCodeIssuedAt = authorizationCodeIssuedAt;
  }

  public Date getAuthorizationCodeExpiresAt() {
    return authorizationCodeExpiresAt;
  }

  public void setAuthorizationCodeExpiresAt(Date authorizationCodeExpiresAt) {
    this.authorizationCodeExpiresAt = authorizationCodeExpiresAt;
  }

  public String getAuthorizationCodeMetadata() {
    return authorizationCodeMetadata;
  }

  public void setAuthorizationCodeMetadata(String authorizationCodeMetadata) {
    this.authorizationCodeMetadata = authorizationCodeMetadata;
  }

  public String getAccessTokenValue() {
    return accessTokenValue;
  }

  public void setAccessTokenValue(String accessTokenValue) {
    this.accessTokenValue = accessTokenValue;
  }

  public Date getAccessTokenIssuedAt() {
    return accessTokenIssuedAt;
  }

  public void setAccessTokenIssuedAt(Date accessTokenIssuedAt) {
    this.accessTokenIssuedAt = accessTokenIssuedAt;
  }

  public Date getAccessTokenExpiresAt() {
    return accessTokenExpiresAt;
  }

  public void setAccessTokenExpiresAt(Date accessTokenExpiresAt) {
    this.accessTokenExpiresAt = accessTokenExpiresAt;
  }

  public String getAccessTokenMetadata() {
    return accessTokenMetadata;
  }

  public void setAccessTokenMetadata(String accessTokenMetadata) {
    this.accessTokenMetadata = accessTokenMetadata;
  }

  public String getAccessTokenType() {
    return accessTokenType;
  }

  public void setAccessTokenType(String accessTokenType) {
    this.accessTokenType = accessTokenType;
  }

  public String getAccessTokenScopes() {
    return accessTokenScopes;
  }

  public void setAccessTokenScopes(String accessTokenScopes) {
    this.accessTokenScopes = accessTokenScopes;
  }

  public String getOidcIdTokenValue() {
    return oidcIdTokenValue;
  }

  public void setOidcIdTokenValue(String oidcIdTokenValue) {
    this.oidcIdTokenValue = oidcIdTokenValue;
  }

  public Date getOidcIdTokenIssuedAt() {
    return oidcIdTokenIssuedAt;
  }

  public void setOidcIdTokenIssuedAt(Date oidcIdTokenIssuedAt) {
    this.oidcIdTokenIssuedAt = oidcIdTokenIssuedAt;
  }

  public Date getOidcIdTokenExpiresAt() {
    return oidcIdTokenExpiresAt;
  }

  public void setOidcIdTokenExpiresAt(Date oidcIdTokenExpiresAt) {
    this.oidcIdTokenExpiresAt = oidcIdTokenExpiresAt;
  }

  public String getOidcIdTokenMetadata() {
    return oidcIdTokenMetadata;
  }

  public void setOidcIdTokenMetadata(String oidcIdTokenMetadata) {
    this.oidcIdTokenMetadata = oidcIdTokenMetadata;
  }

  public String getRefreshTokenValue() {
    return refreshTokenValue;
  }

  public void setRefreshTokenValue(String refreshTokenValue) {
    this.refreshTokenValue = refreshTokenValue;
  }

  public Date getRefreshTokenIssuedAt() {
    return refreshTokenIssuedAt;
  }

  public void setRefreshTokenIssuedAt(Date refreshTokenIssuedAt) {
    this.refreshTokenIssuedAt = refreshTokenIssuedAt;
  }

  public Date getRefreshTokenExpires_At() {
    return refreshTokenExpires_At;
  }

  public void setRefreshTokenExpires_At(Date refreshTokenExpires_At) {
    this.refreshTokenExpires_At = refreshTokenExpires_At;
  }

  public String getRefreshTokenMetadata() {
    return refreshTokenMetadata;
  }

  public void setRefreshTokenMetadata(String refreshTokenMetadata) {
    this.refreshTokenMetadata = refreshTokenMetadata;
  }

  public String getUserCodeValue() {
    return userCodeValue;
  }

  public void setUserCodeValue(String userCodeValue) {
    this.userCodeValue = userCodeValue;
  }

  public Date getUserCodeIssuedAt() {
    return userCodeIssuedAt;
  }

  public void setUserCodeIssuedAt(Date userCodeIssuedAt) {
    this.userCodeIssuedAt = userCodeIssuedAt;
  }

  public Date getUserCodeExpiresAt() {
    return userCodeExpiresAt;
  }

  public void setUserCodeExpiresAt(Date userCodeExpiresAt) {
    this.userCodeExpiresAt = userCodeExpiresAt;
  }

  public String getUserCodeMetadata() {
    return userCodeMetadata;
  }

  public void setUserCodeMetadata(String userCodeMetadata) {
    this.userCodeMetadata = userCodeMetadata;
  }

  public String getDeviceCodeValue() {
    return deviceCodeValue;
  }

  public void setDeviceCodeValue(String deviceCodeValue) {
    this.deviceCodeValue = deviceCodeValue;
  }

  public Date getDeviceCodeIssuedAt() {
    return deviceCodeIssuedAt;
  }

  public void setDeviceCodeIssuedAt(Date deviceCodeIssuedAt) {
    this.deviceCodeIssuedAt = deviceCodeIssuedAt;
  }

  public Date getDeviceCodeExpiresAt() {
    return deviceCodeExpiresAt;
  }

  public void setDeviceCodeExpiresAt(Date deviceCodeExpiresAt) {
    this.deviceCodeExpiresAt = deviceCodeExpiresAt;
  }

  public String getDeviceCodeMetadata() {
    return deviceCodeMetadata;
  }

  public void setDeviceCodeMetadata(String deviceCodeMetadata) {
    this.deviceCodeMetadata = deviceCodeMetadata;
  }

}
