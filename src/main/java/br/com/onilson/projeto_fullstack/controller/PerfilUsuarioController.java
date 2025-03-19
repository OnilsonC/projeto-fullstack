package br.com.onilson.projeto_fullstack.controller;

import br.com.onilson.projeto_fullstack.dto.PerfilUsuarioDTO;
import br.com.onilson.projeto_fullstack.service.PerfilUsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil-usuario")
public class PerfilUsuarioController {

    private final PerfilUsuarioService perfilUsuarioService;

    public PerfilUsuarioController(PerfilUsuarioService perfilUsuarioService) {
        this.perfilUsuarioService = perfilUsuarioService;
    }

    @GetMapping
    public List<PerfilUsuarioDTO> listarTodos() {
        return perfilUsuarioService.listarTodos();
    }

    @GetMapping("/listaporid/{id}")
    public PerfilUsuarioDTO listarPorId(@PathVariable("id") Long id) {
        return perfilUsuarioService.listarPorId(id);
    }

    @PostMapping
    public void inserir(@RequestBody PerfilUsuarioDTO perfilUsuarioDTO) {
        perfilUsuarioService.inserir(perfilUsuarioDTO);
    }

    @PutMapping
    public PerfilUsuarioDTO alterar(@RequestBody PerfilUsuarioDTO perfilUsuarioDTO) {
        return perfilUsuarioService.alterar(perfilUsuarioDTO);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        perfilUsuarioService.excluir(id);
    }
}
