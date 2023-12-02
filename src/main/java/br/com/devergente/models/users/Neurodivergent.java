package br.com.devergente.models.users;

import br.com.devergente.models.Vaga;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private User usuario;

    @ManyToMany
    @JoinTable(
            name = "neurodivergente_vaga",
            joinColumns = @JoinColumn(name = "id_neurodivergente"),
            inverseJoinColumns = @JoinColumn(name = "id_vaga"))
    private List<Vaga> vagas;
}
