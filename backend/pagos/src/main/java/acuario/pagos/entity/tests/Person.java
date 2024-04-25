package acuario.pagos.entity.tests;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {

  @Id
  private Long personId;

  private String name;

  public Person() {
  }

  public Person(Long personId, String name) {
    this.personId = personId;
    this.name = name;
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}