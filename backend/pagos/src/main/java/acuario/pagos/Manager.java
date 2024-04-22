package acuario.pagos;

public enum Manager {
  
  SISTEMA_OPERATIVO(System.getProperty("os.name").toLowerCase());
  private String propiedad;


  private Manager(String propiedad) {
    this.propiedad = propiedad;
  } 

  public String propiedad() {
    return propiedad;
  }
}
