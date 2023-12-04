package br.com.devergente.models;

import br.com.devergente.models.usuarios.Empregador;
import br.com.devergente.models.usuarios.Neurodivergent;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "vaga_emprego")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "data_abertura")
    private Date data_abertura;

    @Column(name = "data_fechamento")
    private Date data_fechamento;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "requisitos")
    private String requisitos;

    @Column(name = "status_vaga")
    private boolean status_vaga;

    @Column(name = "empresa")
    private String empresa;

    // relacionamentos

    @ManyToOne
    @JoinColumn(name = "id_empregador")
    @JsonBackReference(value = "empregador-vaga")
    private Empregador empregador;

    @ManyToMany(mappedBy = "vagas")
    private List<Neurodivergent> neurodivergentes;

    @Override
    public String toString() {
        return "Vaga{" +
                "id=" + id +
                ", data_abertura=" + data_abertura +
                ", data_fechamento=" + data_fechamento +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", requisitos='" + requisitos + '\'' +
                ", status_vaga=" + status_vaga +
                ", empresa='" + empresa + '\'' +
                ", empregador{" +
                "id=" + empregador.getId() +
                ", cnpj='" + empregador.getCnpj() + '\'' +
                ", usuario{" +
                "id=" + empregador.getUsuario().getId() +
                ", nome='" + empregador.getUsuario().getNome() + '\'' +
                ", username='" + empregador.getUsuario().getUsername() + '\'' +
                ", email='" + empregador.getUsuario().getEmail() + '\'' +
                ", senha='" + empregador.getUsuario().getSenha() + '\'' +
                ", data_nascimento=" + empregador.getUsuario().getData_nascimento() +
                ", tipo_perfil=" + empregador.getUsuario().getTipo_perfil() +
                ", codigo=" + empregador.getUsuario().getCodigo() +
                ", endereco{" +
                "id=" + empregador.getUsuario().getEndereco().getId() +
                ", cep='" + empregador.getUsuario().getEndereco().getCep() + '\'' +
                ", logradouro='" + empregador.getUsuario().getEndereco().getLogradouro() + '\'' +
                ", complemento='" + empregador.getUsuario().getEndereco().getComplemento() + '\'' +
                ", numero='" + empregador.getUsuario().getEndereco().getNumero() + '\'' +
                ", referencia='" + empregador.getUsuario().getEndereco().getReferencia() + '\'' +
                ", bairro='" + empregador.getUsuario().getEndereco().getBairro() + '\'' +
                ", cidade='" + empregador.getUsuario().getEndereco().getCidade() + '\'' +
                ", uf='" + empregador.getUsuario().getEndereco().getUf() + '\'' +
                "}" +
                "}" +
                "}" +
                '}';
    }
}
