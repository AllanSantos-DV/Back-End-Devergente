package br.com.devergente.models.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "professional")
public class Professional {

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
    @JsonBackReference(value = "user-professional")
    private User usuario;

    @Override
    public String toString() {
        return "Professional{" +
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


