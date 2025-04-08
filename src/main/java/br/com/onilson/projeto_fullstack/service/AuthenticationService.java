package br.com.onilson.projeto_fullstack.service;

import br.com.onilson.projeto_fullstack.dto.AccessDTO;
import br.com.onilson.projeto_fullstack.dto.AutheticationDTO;
import br.com.onilson.projeto_fullstack.security.jwt.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AuthenticationService(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    public AccessDTO login(AutheticationDTO autheticationDTO) {

        try {
            //Criação da credencial para o spring
            UsernamePasswordAuthenticationToken userAuth =
                    new UsernamePasswordAuthenticationToken(autheticationDTO.getUsername(), autheticationDTO.getPassword());

            //Prepara a autenticação
            Authentication authentication = authenticationManager.authenticate(userAuth);

            //Busca o usuário logado.
            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();
            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AccessDTO acessDTO = new AccessDTO(token);

            return acessDTO;
        }catch (BadCredentialsException e) {
            //TODO LOGIN OU SENHA INVALIDA
        }
        //alterar para buscar a exception
        return new AccessDTO("Acesso negado");
    }
}
