package br.com.devergente.models.usuarios;

import br.com.devergente.models.Endereco;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Usuario {

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
    private Endereco endereco;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Neurodivergent neurodivergent;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Familiar familiar;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Profissional profissional;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Empregador empregador;

    @Override
    public String toString() {
        return "Usuario{" +
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
                ", profissional=" + profissional.getId() +
                ", empregador=" + empregador.getId() +
                '}';
    }
}