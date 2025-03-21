package br.com.onilson.projeto_fullstack.controller;

import br.com.onilson.projeto_fullstack.dto.PermissaoPerfilRecursoDTO;
import br.com.onilson.projeto_fullstack.service.PermissaoPerfilRecursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissao-perfil")
public class PermissaoPerfilRecursoController {

    private final PermissaoPerfilRecursoService pprs;

    public PermissaoPerfilRecursoController(PermissaoPerfilRecursoService pprs) {
        this.pprs = pprs;
    }

    @GetMapping
    public List<PermissaoPerfilRecursoDTO> listarTodos() {
        return pprs.listarTodos();
    }

    @GetMapping("/listaporid/{id}")
    public PermissaoPerfilRecursoDTO listarPorId(@PathVariable("id") Long id) {
        return pprs.listarPorId(id);
    }

    @PostMapping
    public void inserir(@RequestBody PermissaoPerfilRecursoDTO permissaoPerfilRecursoDTO) {
        pprs.inserir(permissaoPerfilRecursoDTO);
    }

    @PutMapping
    public PermissaoPerfilRecursoDTO alterar(@RequestBody PermissaoPerfilRecursoDTO permissaoPerfilRecursoDTO) {
        return pprs.alterar(permissaoPerfilRecursoDTO);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        pprs.excluir(id);
    }
}
