package acuario.msvc.auth.init.service;

import java.util.Map;
import java.sql.Connection;

public interface IDataInitService {

  Connection crearConexion(String url, String username, String password);

  Map<String, Object> verificarSecuencias();

  Map<String, Object> cargarClientesInit();

  void printParams();

}
