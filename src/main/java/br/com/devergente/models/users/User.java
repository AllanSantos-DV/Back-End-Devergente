package br.com.devergente.models.users;

import br.com.devergente.models.Comment;
import br.com.devergente.models.Endereco;
import br.com.devergente.models.Postagem;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "senha", nullable = false)
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

    // relacionamentos

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    @JsonManagedReference("user-endereco")
    private Endereco endereco;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference("user-neuro")
    private Neurodivergent neurodivergent;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference("user-familiar")
    private Familiar familiar;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference("user-professional")
    private Professional professional;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference("user-employer")
    private Employer employer;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", tipo_perfil=" + tipo_perfil +
                ", codigo=" + codigo +
                ", cnpj='" + cnpj + '\'' +
                ", img_perfil='" + img_perfil + '\'' +
                ", img_capa='" + img_capa + '\'' +
                ", bio='" + bio + '\'' +
                ", endereco=" + endereco.getId() +
                ", neurodivergent=" + neurodivergent.getId() +
                ", familiar=" + familiar.getId() +
                ", professional=" + professional.getId() +
                ", employer=" + employer.getId() +
                '}';
    }
}