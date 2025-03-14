package br.com.onilson.projeto_fullstack.controller;

import br.com.onilson.projeto_fullstack.dto.UsuarioDTO;
import br.com.onilson.projeto_fullstack.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioDTO> listarTodos() {
        return usuarioService.listarTodas();
    }

    @GetMapping("/buscar-id/{id}")
    public UsuarioDTO buscarPorId(@PathVariable ("id") Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public void inserir(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.inserir(usuarioDTO);
    }

    @PutMapping
    public UsuarioDTO alterar(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.alterar(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDTO> excluir(@PathVariable("id") Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
