package br.com.devergente.models.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "professional")
@EqualsAndHashCode(callSuper = true)
public class Professional extends User {
    private String registro_profissional;
    private int tipo_profissional;
}


