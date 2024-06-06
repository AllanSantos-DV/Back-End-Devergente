package br.com.devergente.enuns;

import lombok.Getter;

@Getter
public enum EnumUsers {


    /* Tipo Usuários :
    1 - Neurodivergente;
    2 - Familiar;
    3 - Profissional;
    4 - Empregador;
    */

    NEURODIVERGENTE(1),
    FAMILIAR(2),
    PROFISSIONAL(3),
    EMPREGADOR(4);

    private final int tipoUsuario;

    EnumUsers(int tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }

}
