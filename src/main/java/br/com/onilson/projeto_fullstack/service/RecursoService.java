package br.com.onilson.projeto_fullstack.service;

import br.com.onilson.projeto_fullstack.dto.RecursoDTO;
import br.com.onilson.projeto_fullstack.dto.UsuarioDTO;
import br.com.onilson.projeto_fullstack.entity.Recurso;
import br.com.onilson.projeto_fullstack.repository.RecursoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    public List<RecursoDTO> listarTodos() {
        List<Recurso> recursos = recursoRepository.findAll();
        return recursos.stream().map(RecursoDTO::new).toList();
    }

    public RecursoDTO listarPorId(Long id) {
        Recurso recurso = recursoRepository.findById(id).get();
        return new RecursoDTO(recurso);
    }

    public ResponseEntity<RecursoDTO> inserir(RecursoDTO recursoDTO) {
        Recurso recurso = new Recurso(recursoDTO);
        recursoRepository.save(recurso);
        return ResponseEntity.ok().build();
    }

    public RecursoDTO alterar(RecursoDTO recursoDTO) {
        Recurso recurso = new Recurso(recursoDTO);
        return new RecursoDTO(recursoRepository.save(recurso));
    }

    public void excluir (Long id) {
        Recurso recurso = recursoRepository.findById(id).get();
        recursoRepository.delete(recurso);
    }
}
