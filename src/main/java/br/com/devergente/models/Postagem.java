package br.com.devergente.models;

import br.com.devergente.models.usuarios.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
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

    @Column(name = "conteudo")
    private String conteudo;

    @Column(name = "data_postagem")
    private Date data;

    @Column(name = "imagem_url", columnDefinition = "varchar(255) default 'https://i.imgur.com/2ZtU6O2.png'")
    private String imagemUrl;

    @Transient
    private File image;

    // relacionamentos

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonManagedReference("usuario-postagem")
    private UsuarioDTO usuario;

    @OneToMany(mappedBy = "postagem")
    @JsonManagedReference("postagem-curtida")
    private List<Curtida> curtidas;

    @OneToMany(mappedBy = "postagem")
    @JsonManagedReference("postagem-comentario")
    private List<Comentario> comentarios;

    @ManyToMany(mappedBy = "postagens_curtidas")
    private List<UsuarioDTO> usuarios_curtiram;

    @Override
    public String toString() {
        return "Postagem{" +
                "id=" + id +
                ", conteudo='" + conteudo + '\'' +
                ", data=" + data +
                ", imagemUrl='" + imagemUrl + '\'' +
                ", usuario{" +
                "id=" + usuario.getId() +
                ", nome='" + usuario.getNome() + '\'' +
                ", username='" + usuario.getUsername() + '\'' +
                ", img_perfil='" + usuario.getImg_perfil() + '\'' +
                "}" +
                ", curtidas=" + curtidas +
                ", comentarios=" + comentarios +
                ", usuarios_curtiram=" + usuarios_curtiram +
                '}';
    }
}
