package br.com.devergente.models.users;

import br.com.devergente.models.Curriculum;
import br.com.devergente.models.Vaga;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private User usuario;

    @ManyToMany
    @JoinTable(
            name = "empregador_curriculo",
            joinColumns = @JoinColumn(name = "id_empregador"),
            inverseJoinColumns = @JoinColumn(name = "id_curriculo"))
    private List<Curriculum> curriculos;

    @OneToMany(mappedBy = "empregador")
    private List<Vaga> vagas;
}