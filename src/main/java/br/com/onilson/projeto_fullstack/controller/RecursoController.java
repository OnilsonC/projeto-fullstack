package br.com.onilson.projeto_fullstack.controller;

import br.com.onilson.projeto_fullstack.dto.RecursoDTO;
import br.com.onilson.projeto_fullstack.service.RecursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recurso")
@CrossOrigin(value = "*")
public class RecursoController {

    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping
    public List<RecursoDTO> listarTodos() {
        return recursoService.listarTodos();
    }

    @GetMapping("/listaporid/{id}")
    public RecursoDTO listarPorId(@PathVariable("id") Long id) {
        return recursoService.listarPorId(id);
    }

    @PostMapping
    public ResponseEntity<RecursoDTO> inserir(@RequestBody RecursoDTO recursoDTO) {
        return recursoService.inserir(recursoDTO);
    }

    @PutMapping
    public RecursoDTO alterar(@RequestBody RecursoDTO recursoDTO) {
        return recursoService.alterar(recursoDTO);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        recursoService.excluir(id);
    }
}
