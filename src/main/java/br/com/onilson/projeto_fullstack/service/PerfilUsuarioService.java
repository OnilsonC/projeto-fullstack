package br.com.onilson.projeto_fullstack.service;

import br.com.onilson.projeto_fullstack.dto.PerfilUsuarioDTO;
import br.com.onilson.projeto_fullstack.entity.PerfilUsuario;
import br.com.onilson.projeto_fullstack.repository.PerfilUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioService {

    private final PerfilUsuarioRepository perfilUsuarioRepository;

    public PerfilUsuarioService(PerfilUsuarioRepository perfilUsuarioRepository) {
        this.perfilUsuarioRepository = perfilUsuarioRepository;
    }

    public List<PerfilUsuarioDTO> listarTodos() {
        List<PerfilUsuario> perfislUsuarios = perfilUsuarioRepository.findAll();
        return perfislUsuarios.stream()
                .map(PerfilUsuarioDTO::new).toList();
    }

    public PerfilUsuarioDTO listarPorId(Long id) {
        return new PerfilUsuarioDTO(perfilUsuarioRepository.findById(id).get());
    }

    public void inserir(PerfilUsuarioDTO perfilUsuarioDTO) {
        PerfilUsuario perfilUsuario = new PerfilUsuario(perfilUsuarioDTO);
        perfilUsuarioRepository.save(perfilUsuario);
    }

    public PerfilUsuarioDTO alterar(PerfilUsuarioDTO perfilUsuarioDTO) {
        PerfilUsuario perfilUsuario = new PerfilUsuario(perfilUsuarioDTO);
        return new PerfilUsuarioDTO(perfilUsuarioRepository.save(perfilUsuario));
    }

    public void excluir(Long id) {
        PerfilUsuario perfilUsuario = perfilUsuarioRepository.findById(id).get();
        perfilUsuarioRepository.delete(perfilUsuario);
    }
}
