package br.com.devergente.enuns;

public enum EnumProfissional {

        /* Tipo Profissional :
    1 - Psicólogo;
    2 - Psiquiatra;
    3 - Outros;
    */

    PSICOLOGO(1),
    PSIQUIATRA(2),
    OUTROS(3);

    private final int tipoProfissional;

    EnumProfissional(int tipoProfissional){
        this.tipoProfissional = tipoProfissional;
    }

    public int getTipoProfissional(){
        return tipoProfissional;
    }
}
