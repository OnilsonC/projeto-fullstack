package br.com.onilson.projeto_fullstack.dto;


import br.com.onilson.projeto_fullstack.entity.Recurso;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class RecursoDTO {

    private Long id;
    private String nome;
    private String chave;

    public RecursoDTO(Recurso recurso) {
        BeanUtils.copyProperties(recurso, this);
    }
}
