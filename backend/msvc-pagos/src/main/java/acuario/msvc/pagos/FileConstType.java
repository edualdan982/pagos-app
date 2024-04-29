package acuario.msvc.pagos;

public enum FileConstType {
  PROYECTO(System.getProperty("user.dir")),
  FILES(System.getProperty("user.dir").concat("//files//"), "files"),
  REPORT("classpath:reports//", "reports"),
  OUT(System.getProperty("user.dir").concat("//files//").concat("out//"), "out");

  private String direccion;

  private String nombre;

  private FileConstType(String direccion) {
    this.direccion = direccion;
  }

  private FileConstType(String direccion, String nombre) {
    this.direccion = direccion;
    this.nombre = nombre;
  }

  public String direccion() {
    return direccion;
  }

  public String nombre() {
    return nombre;
  }
}
