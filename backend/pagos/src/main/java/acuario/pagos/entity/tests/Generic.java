package acuario.pagos.entity.tests;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Table(name = "test_generic")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Generic {
  
  private Boolean eliminado;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(columnDefinition = "timestamp default current_timestamp")
  private Date fechaRegistro;
}
