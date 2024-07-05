package acuario.msvc.auth.init;

import org.apache.catalina.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import acuario.msvc.auth.init.service.IDataInitService;

@Component
public class InitEjecutar {
  private static final Logger log = LoggerFactory.getLogger(InitEjecutar.class);

  @Value("${spring.datasource.url}")
  private String BD;
  @Value("${spring.profiles.active}")
  private String ENTORNO;

  @Autowired
  private IDataInitService dataInitService;

  @EventListener(ContextRefreshedEvent.class)
  public void ejecutar() {
    log.info("*******Entorno*******  -->  " + ENTORNO);
    log.info("*******Base de Datos*******  -->  " + BD);

    log.info("********************FIN-VERIFICANDO********************");
    log.info("SISTEMA OPERATIVO: ".concat(System.getProperty("os.name").toLowerCase()));
    log.info("Verificando las secuencias:");
    dataInitService.verificarSecuencias();
    log.info("Registrando los clientes por defecto:");
    dataInitService.cargarClientesInit();
  }
}
