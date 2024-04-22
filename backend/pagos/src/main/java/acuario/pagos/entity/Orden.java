package acuario.pagos.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "pago_orden")
@Entity
public class Orden implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdPago")
  @SequenceGenerator(name ="seqIdPago", allocationSize = 1, sequenceName = "pago_id_pago_seq")
  private Integer idPago;

  
  private static final long serialVersionUID = 1L;

}
