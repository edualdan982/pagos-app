package acuario.msvc.auth.auth.entity.client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "oauth2_registered_client")
public class OAth2RegisteredClient {

  @Id
  @Column(length = 100, columnDefinition = "varchar2(100)", nullable = false)
  private String id;
  @Column(length = 100, columnDefinition = "varchar2(100)", nullable = false)
  private String client_id;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(columnDefinition = "timestamp(6) DEFAULT CURRENT_TIMESTAMP", nullable = false)
  private String client_id_issued_at;
  @Column(length = 200, columnDefinition = "varchar2(200) default null")
  private String client_secret;

  @Temporal(TemporalType.TIMESTAMP)
  private String client_secret_expires_at;
  @Column(length = 200, nullable = false)
  private String client_name;
  @Column(length = 1000, nullable = false)
  private String client_authentication_methods;
  @Column(length = 1000, nullable = false)
  private String authorization_grant_types;
  @Column(length = 1000, columnDefinition = "varchar2(1000) default null")
  private String redirect_uris;
  @Column(length = 1000, columnDefinition = "varchar2(1000) default null")
  private String post_logout_redirect_uris;
  @Column(length = 1000, nullable = false)
  private String scopes;
  @Column(length = 2000, nullable = false)
  private String client_settings;
  @Column(length = 2000, nullable = false)
  private String token_settings;
}
