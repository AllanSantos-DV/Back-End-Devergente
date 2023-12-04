package br.com.devergente.models.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "familiar")
public class Familiar {

    @Id
    private Integer id;

    @Column(name = "tipo_familiar")
    private int tipo_familiar;

    // relacionamentos

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    @JsonBackReference(value = "user-familiar")
    private User usuario;

    @Override
    public String toString() {
        return "Familiar{" +
                "id=" + id +
                ", tipo_familiar=" + tipo_familiar +
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