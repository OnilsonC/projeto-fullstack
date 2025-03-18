package br.com.onilson.projeto_fullstack.entity;


import br.com.onilson.projeto_fullstack.dto.PerfilDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PERFIL")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    public Perfil(PerfilDTO perfilDTO) {
        BeanUtils.copyProperties(perfilDTO, this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return Objects.equals(id, perfil.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
