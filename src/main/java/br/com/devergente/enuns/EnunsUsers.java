package br.com.devergente.enuns;

public enum EnunsUsers {


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

    EnunsUsers(int tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }

    public int getTipoUsuario(){
        return tipoUsuario;
    }
}
