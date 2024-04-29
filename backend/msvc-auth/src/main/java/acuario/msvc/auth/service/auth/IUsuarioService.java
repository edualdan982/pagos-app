package acuario.msvc.auth.service.auth;

import acuario.msvc.auth.entity.auth.Usuario;
import acuario.msvc.auth.service.IGenericService;

public interface IUsuarioService extends IGenericService<Usuario, Integer>{
  Usuario buscarPorUsuario(String usuario);
}
