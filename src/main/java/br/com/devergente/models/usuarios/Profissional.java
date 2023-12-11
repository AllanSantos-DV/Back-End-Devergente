package br.com.devergente.models.usuarios;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "professional")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Profissional {

    @Id
    private Integer id;

    @Column(name = "registro_profissional")
    private String registro_profissional;

    @Column(name = "tipo_profissional")
    private int tipo_profissional;

    // relacionamentos

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Override
    public String toString() {
        return "Profissional{" +
                "id=" + id +
                ", registro_profissional='" + registro_profissional + '\'' +
                ", tipo_profissional=" + tipo_profissional +
                ", usuario{" +
                "id=" + usuario.getId() +
                ", nome='" + usuario.getNome() + '\'' +
                ", username='" + usuario.getUsername() + '\'' +
                ", email='" + usuario.getEmail() + '\'' +
                ", senha='" + usuario.getSenha() + '\'' +
                ", data_nascimento=" + usuario.getData_nascimento() +
                ", tipo_perfil=" + usuario.getTipo_perfil() +
                ", codigo=" + usuario.getCodigo() +
                ", cnpj='" + usuario.getCnpj() + '\'' +
                ", img_perfil='" + usuario.getImg_perfil() + '\'' +
                ", img_capa='" + usuario.getImg_capa() + '\'' +
                ", bio='" + usuario.getBio() + '\'' +
                "}}";
    }
}


