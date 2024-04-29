package acuario.authserver.service.auth;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import acuario.authserver.entity.auth.Usuario;
import acuario.authserver.idao.auth.IUsuarioDao;
import acuario.authserver.service.GenericService;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {
  private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

  @Autowired
  private IUsuarioDao repository;

  @Transactional
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
      Usuario usuario = repository.buscarPorUsuario(username);
      log.info("Usuario login: {}", usuario.getUsuario());

      return new User(usuario.getUsuario(), usuario.getClave(), true, true, true, true,
          Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
    } catch (RuntimeException e) {
      String error = "Error en login, no existe el usuario " + username;
      log.error(e.getMessage() == null ? "Sin detalle del error." : e.getMessage());
      throw new UsernameNotFoundException(error);
    }
  }

  @Transactional
  @Override
  public Usuario guardar(Usuario entidad) {
    GenericService.logDebugMetod(log, UsuarioService.class.getSimpleName(), "guardar", Usuario.class.getSimpleName());
    return repository.save(entidad);
  }

  @Transactional
  @Override
  public Boolean eliminarPorId(Integer id) {
    GenericService.logDebugMetod(log, UsuarioService.class.getSimpleName(), "eliminarPorId",
        Usuario.class.getSimpleName());
    try {
      repository.eliminarPorId(id);
      return true;
    } catch (Exception e) {
      return false;
    }

  }

  @Transactional(readOnly = true)
  @Override
  public Optional<Usuario> buscarPorId(Integer id) {
    return repository.buscarPorId(id);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Usuario> listar() {
    return repository.listar();
  }

  @Override
  public Usuario buscarPorUsuario(String usuario) {
    return new Usuario();
  }

}
