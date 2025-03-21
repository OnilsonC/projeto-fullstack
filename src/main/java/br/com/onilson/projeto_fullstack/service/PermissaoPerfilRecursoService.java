package br.com.onilson.projeto_fullstack.service;

import br.com.onilson.projeto_fullstack.dto.PermissaoPerfilRecursoDTO;
import br.com.onilson.projeto_fullstack.entity.PermissaoPerfilRecurso;
import br.com.onilson.projeto_fullstack.repository.PermissaoPerfilRecursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoPerfilRecursoService {

    private final PermissaoPerfilRecursoRepository ppr;

    public PermissaoPerfilRecursoService(PermissaoPerfilRecursoRepository ppr) {
        this.ppr = ppr;
    }

    public List<PermissaoPerfilRecursoDTO> listarTodos() {
        List<PermissaoPerfilRecurso> permissaoPerfilRecursoList = ppr.findAll();
        return permissaoPerfilRecursoList.stream()
                .map(PermissaoPerfilRecursoDTO::new).toList();
    }

    public PermissaoPerfilRecursoDTO listarPorId(Long id) {
        return new PermissaoPerfilRecursoDTO(ppr.findById(id).get());
    }

    public void inserir(PermissaoPerfilRecursoDTO permissaoPerfilRecursoDTO) {
        PermissaoPerfilRecurso ppre = new PermissaoPerfilRecurso(permissaoPerfilRecursoDTO);
        ppr.save(ppre);
    }

    public PermissaoPerfilRecursoDTO alterar(PermissaoPerfilRecursoDTO permissaoPerfilRecursoDTO) {
        PermissaoPerfilRecurso ppre = new PermissaoPerfilRecurso(permissaoPerfilRecursoDTO);
        return new PermissaoPerfilRecursoDTO(ppr.save(ppre));
    }

    public void excluir(Long id) {
        PermissaoPerfilRecurso permissaoPerfilRecurso = ppr.findById(id).get();
        ppr.delete(permissaoPerfilRecurso);
    }
}
