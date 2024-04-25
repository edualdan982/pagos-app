package acuario.auth.service.auth;

import acuario.auth.entity.auth.Usuario;
import acuario.auth.service.IGenericService;

public interface IUsuarioService extends IGenericService<Usuario, Integer>{
  Usuario buscarPorUsuario(String usuario);
}
