package br.com.onilson.projeto_fullstack.repository;

import br.com.onilson.projeto_fullstack.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByLogin(String login);
}
