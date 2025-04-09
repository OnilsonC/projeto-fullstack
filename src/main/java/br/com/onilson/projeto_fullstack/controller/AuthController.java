package br.com.onilson.projeto_fullstack.controller;


import br.com.onilson.projeto_fullstack.dto.AutheticationDTO;
import br.com.onilson.projeto_fullstack.dto.UsuarioDTO;
import br.com.onilson.projeto_fullstack.service.AuthenticationService;
import br.com.onilson.projeto_fullstack.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final AuthenticationService authService;
    private final UsuarioService usuarioService;

    public AuthController(AuthenticationService authService, UsuarioService usuarioService) {
        this.authService = authService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AutheticationDTO autheticationDTO) {
        return ResponseEntity.ok(authService.login(autheticationDTO));
    }

    @PostMapping("/novousuario")
    public void inserirNovoUsuario(@RequestBody UsuarioDTO usuarioDTO) {
         usuarioService.inserirNovoUsuario(usuarioDTO);
    }
}
