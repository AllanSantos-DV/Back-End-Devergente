package br.com.devergente.models.users;

import br.com.devergente.models.Curriculum;
import br.com.devergente.models.Vaga;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empregador")
public class Employer {

    @Id
    private Integer id;

    @Column(name = "cnpj")
    private String cnpj;

    // relacionamentos

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    @JsonBackReference(value = "user-employer")
    private User usuario;

    @ManyToMany
    @JoinTable(
            name = "empregador_curriculo",
            joinColumns = @JoinColumn(name = "id_empregador"),
            inverseJoinColumns = @JoinColumn(name = "id_curriculo"))
    private List<Curriculum> curriculos;

    @OneToMany(mappedBy = "empregador")
    @JsonManagedReference("empregador-vaga")
    private List<Vaga> vagas;

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
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