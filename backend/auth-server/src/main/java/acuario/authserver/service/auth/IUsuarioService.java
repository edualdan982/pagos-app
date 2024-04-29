package acuario.authserver.service.auth;

import acuario.authserver.entity.auth.Usuario;
import acuario.authserver.service.IGenericService;

public interface IUsuarioService extends IGenericService<Usuario, Integer>{
  Usuario buscarPorUsuario(String usuario);
}
