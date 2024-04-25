package acuario.auth.service;

import org.slf4j.Logger;

public class GenericService {
  private GenericService() {
  }

  public static void logDebugMetod(Logger log, String serviceName, String methodName, String nameEntity) {
    log.debug("Sevicio {} ejecutadando el metodo {} en la entidad {}", serviceName, methodName, nameEntity);
  }

  public static void logDetailsMessage(Logger log, String msg, String serviceName, String methodName) {
    log.error("Eror en el servicio {}:{} de la entidad. Detalle: {}", serviceName, methodName,
        (msg == null ? "Sin detalle" : msg));
  }
}
