package acuario.msvc.auth.auth.service;

import acuario.msvc.auth.auth.entity.Usuario;
import acuario.msvc.auth.service.IGenericService;

public interface IUsuarioService extends IGenericService<Usuario, Integer>{
  Usuario buscarPorUsuario(String usuario);
}
