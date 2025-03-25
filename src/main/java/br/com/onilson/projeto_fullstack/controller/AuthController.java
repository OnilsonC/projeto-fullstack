package br.com.onilson.projeto_fullstack.controller;


import br.com.onilson.projeto_fullstack.dto.AutheticationDTO;
import br.com.onilson.projeto_fullstack.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final AuthenticationService authService;

    public AuthController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AutheticationDTO autheticationDTO) {
        return ResponseEntity.ok(authService.login(autheticationDTO));
    }
}
