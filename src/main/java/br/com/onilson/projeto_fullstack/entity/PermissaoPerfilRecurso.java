package br.com.onilson.projeto_fullstack.entity;


import br.com.onilson.projeto_fullstack.dto.PermissaoPerfilRecursoDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "PERMISSAO_PERFIL_RECURSO")
public class PermissaoPerfilRecurso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "recurso_id")
    private Recurso recurso;

    public PermissaoPerfilRecurso(PermissaoPerfilRecursoDTO permissaoPerfilRecursoDTO) {
        BeanUtils.copyProperties(permissaoPerfilRecursoDTO, this);
        if (permissaoPerfilRecursoDTO != null && permissaoPerfilRecursoDTO.getPerfil() != null) {
            this.perfil = new Perfil(permissaoPerfilRecursoDTO.getPerfil());
        }
        if (permissaoPerfilRecursoDTO != null && permissaoPerfilRecursoDTO.getRecurso() != null) {
            this.recurso = new Recurso(permissaoPerfilRecursoDTO.getRecurso());
        }
    }
}
