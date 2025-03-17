package br.com.onilson.projeto_fullstack.repository;

import br.com.onilson.projeto_fullstack.entity.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecursoRepository extends JpaRepository<Recurso, Long> {
}
