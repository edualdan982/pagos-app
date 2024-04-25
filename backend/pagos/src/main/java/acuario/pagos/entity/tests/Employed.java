package acuario.pagos.entity.tests;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name ="test_employed")
@Entity
public class Employed extends Person {
  
  private String company;

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  

}
