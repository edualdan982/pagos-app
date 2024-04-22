package acuario.pagos.entity.tests;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name ="test_other")
@Entity
public class Other extends Generic{
  @Id
  private Integer idOther;
  
  private String nombre;
  private Integer idPago;
}
