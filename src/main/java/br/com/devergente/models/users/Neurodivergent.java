package br.com.devergente.models.users;

import br.com.devergente.enuns.EnunsNeuro;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "neurodivergente")
public class Neurodivergent {

    @Id
    private Integer id;

    @Column(name = "laudo_neurodivergente")
    private String laudo;

    @Column(name = "tipo_neurodivergencia")
    private int tipo_neurodivergencia;

    // relacionamentos

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    @JsonBackReference(value = "user-neuro")
    private User usuario;

    @ManyToMany
    @JoinTable(
            name = "neurodivergente_vaga",
            joinColumns = @JoinColumn(name = "id_neurodivergente"),
            inverseJoinColumns = @JoinColumn(name = "id_vaga"))
    private List<Vaga> vagas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curriculum_id", referencedColumnName = "id")
    @JsonManagedReference("neuro-curriculo")
    private Curriculum curriculum;

    @Override
    public String toString() {
        return "Neurodivergent{" +
                "id=" + id +
                ", laudo='" + laudo + '\'' +
                ", tipo_neurodivergencia=" + tipo_neurodivergencia +
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
