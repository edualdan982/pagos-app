package acuario.auth.entity.auth;

import acuario.auth.entity.GenericEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "auth_usuario")
public class Usuario extends GenericEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authIdUuarioSeq")
  @SequenceGenerator(name = "authIdUuarioSeq", allocationSize = 1, sequenceName = "auth_id_usuario_seq")
  private Integer idUsuario;

  @NotEmpty
  @Size(max = 64)
  @Column(length = 64)
  private String usuario;

  @Column(columnDefinition = "number(1,0) default 0")
  private Boolean activo;

  @Size(max = 512)
  @Column(length = 512)
  private String clave;

  public Usuario() {
    super();
  }

  @PrePersist
  public void prePersist() {
    super.initial();
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public Boolean getActivo() {
    return activo;
  }

  public void setActivo(Boolean activo) {
    this.activo = activo;
  }

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

}
