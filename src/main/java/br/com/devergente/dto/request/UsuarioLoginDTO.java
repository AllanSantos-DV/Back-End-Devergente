package br.com.devergente.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UsuarioLoginDTO {
    private String email;
    private String senha;
}
