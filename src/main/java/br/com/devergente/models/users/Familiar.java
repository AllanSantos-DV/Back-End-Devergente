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

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private User usuario;
}