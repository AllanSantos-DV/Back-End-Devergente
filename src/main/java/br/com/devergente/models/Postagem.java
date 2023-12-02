package br.com.devergente.models;

import br.com.devergente.models.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "postagem")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "conteudo")
    private String conteudo;

    @Column(name = "data_postagem")
    private Date data;

    @Column(name = "imagem_url", columnDefinition = "varchar(255) default 'https://i.imgur.com/2ZtU6O2.png'")
    private String imagemUrl;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User usuario;

    @OneToMany(mappedBy = "postagem")
    private List<Curtida> curtidas;

    @OneToMany(mappedBy = "postagem")
    private List<Comment> comentarios;

    @ManyToMany(mappedBy = "postagens_curtidas")
    private List<User> usuarios_curtiram;
}
