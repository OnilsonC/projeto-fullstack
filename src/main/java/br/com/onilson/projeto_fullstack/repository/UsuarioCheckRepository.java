package br.com.onilson.projeto_fullstack.repository;

import br.com.onilson.projeto_fullstack.entity.UsuarioCheck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioCheckRepository extends JpaRepository<UsuarioCheck, Long> {

    Optional<UsuarioCheck> findByUuid(UUID uuid);
}
