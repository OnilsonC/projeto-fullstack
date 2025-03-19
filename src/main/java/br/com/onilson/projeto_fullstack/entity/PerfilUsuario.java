package br.com.onilson.projeto_fullstack.entity;

import br.com.onilson.projeto_fullstack.dto.PerfilDTO;
import br.com.onilson.projeto_fullstack.dto.PerfilUsuarioDTO;
import br.com.onilson.projeto_fullstack.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "PERFIL_USUARIO")
@Getter
@Setter
@NoArgsConstructor
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    public PerfilUsuario(PerfilUsuarioDTO perfilUsuarioDTO) {
        BeanUtils.copyProperties(perfilUsuarioDTO, this);
        if (perfilUsuarioDTO != null && perfilUsuarioDTO.getUsuario() != null) {
            this.usuario = new Usuario(perfilUsuarioDTO.getUsuario());
        }
        if (perfilUsuarioDTO != null && perfilUsuarioDTO.getPerfil() != null) {
            this.perfil = new Perfil(perfilUsuarioDTO.getPerfil());
        }
    }
}
