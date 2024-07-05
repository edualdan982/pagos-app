package acuario.msvc.auth.auth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acuario.msvc.auth.auth.entity.client.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
  Optional<Client> findByClientId(String clientId);

  @Query("SELECT count(c) FROM Client c WhERE c.clientId = :clientId")
  Boolean verificarClient(String clientId);
}
