package br.com.devergente.models;

import br.com.devergente.models.usuarios.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "conteudo")
    private String conteudo;

    @Column(name = "data_criacao")
    private Date data;

    // relacionamentos

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioDTO usuario;

    @ManyToOne
    @JoinColumn(name = "id_postagem")
    @JsonBackReference(value = "postagem-comentario")
    private Postagem postagem;

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", conteudo='" + conteudo + '\'' +
                ", data=" + data +
                ", usuario{" +
                "id=" + usuario.getId() +
                ", nome='" + usuario.getNome() + '\'' +
                ", username='" + usuario.getUsername() + '\'' +
                ", img_perfil='" + usuario.getImg_perfil() + '\'' +
                "}, postagem{" +
                "id=" + postagem.getId() +
                ", conteudo='" + postagem.getConteudo() + '\'' +
                ", data=" + postagem.getData() +
                ", imagemUrl='" + postagem.getImagemUrl() + '\'' +
                ", usuario{" +
                "id=" + postagem.getUsuario().getId() +
                ", nome='" + postagem.getUsuario().getNome() + '\'' +
                ", username='" + postagem.getUsuario().getUsername() + '\'' +
                ", img_perfil='" + postagem.getUsuario().getImg_perfil() + '\'' +
                "}}";
    }
}
