package br.com.onilson.projeto_fullstack.dto;

import br.com.onilson.projeto_fullstack.entity.Usuario;
import br.com.onilson.projeto_fullstack.entity.enums.TipoSituacaoUsuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private TipoSituacaoUsuario situacao;

    public UsuarioDTO(Usuario usuario) {
        BeanUtils.copyProperties(usuario, this);
    }
}
