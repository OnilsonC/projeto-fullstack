package br.com.onilson.projeto_fullstack.dto;

import br.com.onilson.projeto_fullstack.entity.Perfil;
import br.com.onilson.projeto_fullstack.entity.PermissaoPerfilRecurso;
import br.com.onilson.projeto_fullstack.entity.Recurso;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


@Getter
@Setter
@NoArgsConstructor
public class PermissaoPerfilRecursoDTO {

    private Long id;
    private PerfilDTO perfil;
    private RecursoDTO recurso;

    public PermissaoPerfilRecursoDTO(PermissaoPerfilRecurso permissaoPerfilRecurso) {
        BeanUtils.copyProperties(permissaoPerfilRecurso, this);
        if (permissaoPerfilRecurso != null && permissaoPerfilRecurso.getPerfil() != null) {
            this.perfil = new PerfilDTO(permissaoPerfilRecurso.getPerfil());
        }
        if (permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecurso() != null) {
            this.recurso = new RecursoDTO(permissaoPerfilRecurso.getRecurso());
        }
    }
}
