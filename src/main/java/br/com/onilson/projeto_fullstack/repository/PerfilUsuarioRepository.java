package br.com.onilson.projeto_fullstack.repository;

import br.com.onilson.projeto_fullstack.entity.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Long> {
}
