package br.com.onilson.projeto_fullstack.dto;

import br.com.onilson.projeto_fullstack.entity.Perfil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Setter
@Getter
public class PerfilDTO {

    private Long id;
    private String descricao;

    public PerfilDTO(Perfil perfil) {
        BeanUtils.copyProperties(perfil, this);
    }
}
