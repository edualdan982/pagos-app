package acuario.msvc.auth.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@MappedSuperclass
public abstract class GenericEntity {
  
  @Column(columnDefinition = "number(1,0) default 0")
  private Boolean eliminado;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(columnDefinition = "timestamp default current_timestamp")
  private Date fechaRegistro;

  protected GenericEntity(){
    this.initial();
  }

  protected void initial(){
    this.eliminado = false;
    this.fechaRegistro = new Date();
  }

  public Boolean getEliminado() {
    return eliminado;
  }

  public void setEliminado(Boolean eliminado) {
    this.eliminado = eliminado;
  }

  public Date getFechaRegistro() {
    return fechaRegistro;
  }

  public void setFechaRegistro(Date fechaRegistro) {
    this.fechaRegistro = fechaRegistro;
  }

  
}
