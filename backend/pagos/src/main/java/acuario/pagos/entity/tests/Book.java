package acuario.pagos.entity.tests;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name ="test_book")
@Entity
public class Book extends MyProduct{
  private String author;
}
