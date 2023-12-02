package br.com.devergente.models;

import br.com.devergente.models.users.Employer;
import br.com.devergente.models.users.Neurodivergent;
import br.com.devergente.models.users.User;
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

    @ManyToOne
    @JoinColumn(name = "id_empregador")
    private Employer empregador;

    @ManyToMany(mappedBy = "vagas")
    private List<Neurodivergent> neurodivergentes;
}
