package br.com.devergente.models.users;

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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int tipo_perfil;
    private String email;
    private String senha;
    private Date data_nascimento;
    private String img_perfil;
    private String username;
    private String bio;
    private String img_capa;
    private String nome;
    private String imagemUrl;
}