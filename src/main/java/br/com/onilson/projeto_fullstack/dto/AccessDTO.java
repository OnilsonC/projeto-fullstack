package br.com.onilson.projeto_fullstack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccessDTO {

    private String token;

    //TODO implementar o retorno do usuário e liberações (authorities)

}
