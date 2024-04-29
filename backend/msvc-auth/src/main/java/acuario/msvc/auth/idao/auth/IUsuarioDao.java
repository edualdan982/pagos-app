package acuario.msvc.auth.idao.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import acuario.msvc.auth.entity.auth.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {

  @Modifying
  @Query("UPDATE Usuario u SET u.eliminado = true WHERE u.idUsuario = :id")
  void eliminarPorId(Integer id);

  @Query("SELECT u FROM Usuario u WHERE u.eliminado = false AND u.idUsuario = :id")
  Optional<Usuario> buscarPorId(Integer id);

  @Query("SELECT u FROM Usuario u WHERE u.eliminado = false")
  List<Usuario> listar();

  @Query("SELECT u FROM Usuario u WHERE u.eliminado = false AND u.usuario = :usuario")
  Usuario buscarPorUsuario(String usuario);

}
