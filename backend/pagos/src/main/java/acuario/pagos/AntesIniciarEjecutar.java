package acuario.pagos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import acuario.pagos.config.init.IDataInitConfig;

@Component
public class AntesIniciarEjecutar {
  private static final Logger log = LoggerFactory.getLogger(AntesIniciarEjecutar.class);
  @Autowired
  private Environment env;

  @Autowired
  private IDataInitConfig dataInitConfig;

  @EventListener(ContextRefreshedEvent.class)
  public void execIfChanges() {
    log.info("********************VERIFICANDO********************");
    log.info("Verificando las secuencias:");
    dataInitConfig.verificarData();
    log.info("Fin del verificado de secuencias");
    log.info("Verificación de carpetas para el almacenaje de archivos.");
    log.info("*******ENTORNO*******  --> {}",
        env.getProperty("spring.profiles.active") == null ? "Sin entorno" : env.getProperty("spring.profiles.active"));
    log.info("*******DATABASE*******  --> {}", env.getProperty("spring.datasource.url"));

    log.info("********************FIN-VERIFICANDO********************");
    log.info("SISTEMA OPERATIVO: ".concat(Manager.SISTEMA_OPERATIVO.propiedad()));

  }
}
