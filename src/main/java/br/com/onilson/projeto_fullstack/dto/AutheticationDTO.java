package br.com.onilson.projeto_fullstack.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AutheticationDTO {

    private String username;
    private String password;
}
