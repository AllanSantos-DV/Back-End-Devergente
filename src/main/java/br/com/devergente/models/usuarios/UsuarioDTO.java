package br.com.devergente.models.usuarios;


import br.com.devergente.models.Comentario;
import br.com.devergente.models.Curtida;
import br.com.devergente.models.Postagem;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarioDTO")
public class UsuarioDTO {

    public UsuarioDTO(Integer id, String nome, String username, String img_perfil, String email) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.img_perfil = img_perfil;
        this.email = email;
    }

    @Id
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "username")
    private String username;

    @Column(name = "img_perfil")
    private String img_perfil;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "usuario")
    @JsonBackReference("usuario-postagem")
    private List<Postagem> postagens;

    @OneToMany(mappedBy = "usuario")
    private List<Curtida> curtidas;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @ManyToMany
    @JoinTable(
            name = "usuario_postagem_curtida",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_postagem"))
    private List<Postagem> postagens_curtidas;

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", username='" + username + '\'' +
                ", img_perfil='" + img_perfil + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
