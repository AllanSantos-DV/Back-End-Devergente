package br.com.devergente.models;

import br.com.devergente.models.users.Employer;
import br.com.devergente.models.users.Neurodivergent;
import br.com.devergente.models.users.Professional;
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

    @OneToOne
    @JoinColumn(name = "neurodivergente_usuario_id")
    private Neurodivergent neurodivergent;

    @ManyToMany(mappedBy = "curriculos")
    private List<Employer> empregadores;
}
