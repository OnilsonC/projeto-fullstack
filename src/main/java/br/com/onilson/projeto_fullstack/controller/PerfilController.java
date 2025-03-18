package br.com.onilson.projeto_fullstack.controller;

import br.com.onilson.projeto_fullstack.dto.PerfilDTO;
import br.com.onilson.projeto_fullstack.service.PerfilService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
@CrossOrigin(value = "*")
public class PerfilController {

    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping
    public List<PerfilDTO> listarTodos() {
        return perfilService.listarTodos();
    }

    @GetMapping("/listaporid/{id}")
    public PerfilDTO listarPorId(@PathVariable("id") Long id) {
        return perfilService.listarPorId(id);
    }

    @PostMapping
    public void inserir(@RequestBody PerfilDTO perfilDTO) {
        perfilService.inserir(perfilDTO);
    }

    @PutMapping
    public PerfilDTO alterar(@RequestBody PerfilDTO perfilDTO) {
        return perfilService.alterar(perfilDTO);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        perfilService.excluir(id);
    }
}
