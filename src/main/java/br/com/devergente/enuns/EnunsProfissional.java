package br.com.devergente.enuns;

public enum EnunsProfissional {

        /* Tipo Profissional :
    1 - Psicólogo;
    2 - Psiquiatra;
    3 - Outros;
    */

    PSICOLOGO(1),
    PSIQUIATRA(2),
    OUTROS(3);

    private final int tipoProfissional;

    EnunsProfissional(int tipoProfissional){
        this.tipoProfissional = tipoProfissional;
    }

    public int getTipoProfissional(){
        return tipoProfissional;
    }
}
