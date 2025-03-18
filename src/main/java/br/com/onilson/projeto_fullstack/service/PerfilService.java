package br.com.onilson.projeto_fullstack.service;

import br.com.onilson.projeto_fullstack.dto.PerfilDTO;
import br.com.onilson.projeto_fullstack.entity.Perfil;
import br.com.onilson.projeto_fullstack.repository.PerfilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public List<PerfilDTO> listarTodos() {
        List<Perfil> perfis = perfilRepository.findAll();
        return perfis.stream()
                .map(PerfilDTO::new).toList();
    }

    public PerfilDTO listarPorId(Long id) {
        return new PerfilDTO(perfilRepository.findById(id).get());
    }

    public void inserir(PerfilDTO perfilDTO) {
        Perfil p = new Perfil(perfilDTO);
        perfilRepository.save(p);
    }

    public PerfilDTO alterar(PerfilDTO perfilDTO) {
        Perfil p = new Perfil(perfilDTO);
        return new PerfilDTO(perfilRepository.save(p));
    }

    public void excluir(Long id) {
        Perfil p = perfilRepository.findById(id).get();
        perfilRepository.delete(p);
    }
}
