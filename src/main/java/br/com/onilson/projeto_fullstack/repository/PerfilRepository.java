package br.com.onilson.projeto_fullstack.repository;

import br.com.onilson.projeto_fullstack.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
