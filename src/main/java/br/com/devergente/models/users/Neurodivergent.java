package br.com.devergente.models.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "neurodivergente")
public class Neurodivergent extends User{
    private int tipo_neurodivergencia;
    private String laudo_neurodivergente;
}
