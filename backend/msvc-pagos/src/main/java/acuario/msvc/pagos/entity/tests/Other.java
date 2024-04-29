package acuario.msvc.pagos.entity.tests;

import acuario.msvc.pagos.entity.GenericEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "test_other")
@Entity
public class Other extends GenericEntity {
  @Id
  private Integer idOther;

  private String nombre;
  private Integer idPago;

  public Integer getIdOther() {
    return idOther;
  }

  public void setIdOther(Integer idOther) {
    this.idOther = idOther;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getIdPago() {
    return idPago;
  }

  public void setIdPago(Integer idPago) {
    this.idPago = idPago;
  }

}
