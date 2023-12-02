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

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private User usuario;
}


