package br.com.devergente.models;

import br.com.devergente.models.usuarios.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    // relacionamentos

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioDTO usuario;

    @ManyToOne
    @JsonBackReference(value = "postagem-curtida")
    private Postagem postagem;

    @Override
    public String toString() {
        return "Curtida{" +
                "id=" + id +
                ", total_curtidas=" + total_curtidas +
                ", usuario{" +
                "id=" + usuario.getId() +
                ", nome='" + usuario.getNome() + '\'' +
                ", username='" + usuario.getUsername() + '\'' +
                ", img_perfil='" + usuario.getImg_perfil() + '\'' +
                "}, postagem{" +
                "id=" + postagem.getId() +
                ", conteudo='" + postagem.getConteudo() + '\'' +
                ", data_criacao=" + postagem.getData() +
                ", total_curtidas=" + postagem.getCurtidas() +
                ", total_comentarios=" + postagem.getComentarios() +
                ", usuario{" +
                "id=" + postagem.getUsuario().getId() +
                ", nome='" + postagem.getUsuario().getNome() + '\'' +
                ", username='" + postagem.getUsuario().getUsername() + '\'' +
                "}}";
    }
}
