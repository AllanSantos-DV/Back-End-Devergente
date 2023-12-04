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
@Table(name = "curriculum")
public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tel01")
    private String tel01;

    @Column(name = "tel02")
    private String tel02;

    @Column(name = "area_interesse")
    private String area_interesse;

    @Column(name = "habilidades")
    private String habilidades;

    @Column(name = "formacao")
    private String formacao;

    @Column(name = "instituicao_ensino")
    private String instituicao_ensino;

    @Column(name = "experiencia_anterior")
    private boolean experiencia_anterior;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "data_inicio")
    private Date data_inicio;

    @Column(name = "data_fim")
    private Date data_fim;

    @Column(name = "resumo")
    private String resumo;

    // relacionamentos

    @OneToOne(mappedBy = "curriculum")
    @JsonBackReference(value = "neuro-curriculo")
    private Neurodivergent neurodivergent;

    @ManyToMany(mappedBy = "curriculos")
    private List<Empregador> empregadores;

    @Override
    public String toString() {
        return "Curriculum{" +
                "id=" + id +
                ", tel01='" + tel01 + '\'' +
                ", tel02='" + tel02 + '\'' +
                ", area_interesse='" + area_interesse + '\'' +
                ", habilidades='" + habilidades + '\'' +
                ", formacao='" + formacao + '\'' +
                ", instituicao_ensino='" + instituicao_ensino + '\'' +
                ", experiencia_anterior=" + experiencia_anterior +
                ", cargo='" + cargo + '\'' +
                ", empresa='" + empresa + '\'' +
                ", data_inicio=" + data_inicio +
                ", data_fim=" + data_fim +
                ", resumo='" + resumo + '\'' +
                ", neurodivergent{" +
                "id=" + neurodivergent.getId() +
                ", laudo='" + neurodivergent.getLaudo() + '\'' +
                ", tipo_neurodivergencia=" + neurodivergent.getTipo_neurodivergencia() +
                ", usuario{" +
                "id=" + neurodivergent.getUsuario().getId() +
                ", nome='" + neurodivergent.getUsuario().getNome() + '\'' +
                ", username='" + neurodivergent.getUsuario().getUsername() + '\'' +
                ", email='" + neurodivergent.getUsuario().getEmail() + '\'' +
                ", senha='" + neurodivergent.getUsuario().getSenha() + '\'' +
                ", data_nascimento=" + neurodivergent.getUsuario().getData_nascimento() +
                ", tipo_perfil=" + neurodivergent.getUsuario().getTipo_perfil() +
                ", codigo=" + neurodivergent.getUsuario().getCodigo() +
                ", cnpj='" + neurodivergent.getUsuario().getCnpj() + '\'' +
                ", img_perfil='" + neurodivergent.getUsuario().getImg_perfil() + '\'' +
                ", img_capa='" + neurodivergent.getUsuario().getImg_capa() + '\'' +
                ", bio='" + neurodivergent.getUsuario().getBio() + '\'' +
                "}}";
    }
}
