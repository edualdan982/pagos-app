package acuario.msvc.auth.init;

import org.apache.catalina.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import acuario.msvc.auth.init.service.IDataInitService;

@Component
public class AntesIniciarEjecutar {
  private static final Logger log = LoggerFactory.getLogger(AntesIniciarEjecutar.class);
  @Autowired
  private IDataInitService dataInitService;

  @EventListener(ContextRefreshedEvent.class)
  public void ejecutar() {
    log.info("Ejecutando AntesIniciarEjecutar.ejecutar()");
    dataInitService.printParams();
    log.info("********************VERIFICANDO********************");
    
    log.info("Verificando las secuencias:");
    dataInitService.verificarSecuencias();
    log.info("Fin del verificado de secuencias");
    log.info("Cargar clientes por defecto:");
    dataInitService.cargarClientesInit();
    log.info("Fin de cargar clientes por defecto");

    log.info("********************FIN-VERIFICANDO********************");
  }

}
