package br.com.devergente.models.users;

import br.com.devergente.models.Comment;
import br.com.devergente.models.Endereco;
import br.com.devergente.models.Postagem;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "data_nascimento", nullable = false)
    private Date data_nascimento;

    @Column(name = "tipo_perfil", nullable = false)
    private int tipo_perfil;

    @Transient
    private int codigo;

    @Transient
    private String cnpj;

    @Column(name = "img_perfil")
    private String img_perfil;

    @Column(name = "img_capa")
    private String img_capa;

    @Column(name = "bio")
    private String bio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Neurodivergent neurodivergent;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Familiar familiar;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Professional professional;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Employer employer;

    @OneToMany(mappedBy = "usuario")
    private List<Postagem> postagens;

    @ManyToMany
    @JoinTable(
            name = "usuario_postagem_curtida",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_postagem"))
    private List<Postagem> postagens_curtidas;

    @OneToMany(mappedBy = "usuario")
    private List<Comment> comentarios;
}