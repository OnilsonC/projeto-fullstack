package br.com.onilson.projeto_fullstack.dto;

import br.com.onilson.projeto_fullstack.entity.PerfilUsuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class PerfilUsuarioDTO {

    private Long id;
    private UsuarioDTO usuario;
    private PerfilDTO perfil;

    public PerfilUsuarioDTO(PerfilUsuario perfilUsuario) {
        BeanUtils.copyProperties(perfilUsuario, this);
        if (perfilUsuario != null && perfilUsuario.getUsuario() != null) {
            this.usuario = new UsuarioDTO(perfilUsuario.getUsuario());
        }
        if (perfilUsuario != null && perfilUsuario.getPerfil() != null) {
            this.perfil = new PerfilDTO(perfilUsuario.getPerfil());
        }
    }
}
