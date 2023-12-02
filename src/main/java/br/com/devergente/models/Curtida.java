package br.com.devergente.models;

import br.com.devergente.models.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curtida")
public class Curtida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "total_curtidas")
    private Integer total_curtidas;

    @ManyToOne
    private User user;

    @ManyToOne
    private Postagem postagem;
}
