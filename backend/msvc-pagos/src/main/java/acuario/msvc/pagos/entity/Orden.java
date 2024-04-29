package acuario.msvc.pagos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Table(name = "pago_orden")
@Entity
public class Orden extends GenericEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdPago")
  @SequenceGenerator(name ="seqIdPagoOden", allocationSize = 1, sequenceName = "pago_id_orden_pago_seq")
  private Integer idPagoOrden;

  @Size(max = 64)
  @Column(length = 64)
  private String identificador;

  public Orden(){
    super();
  }

  @PrePersist
  public void prePersist(){
    super.initial();
  }

}
