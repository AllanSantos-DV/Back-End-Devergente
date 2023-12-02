package br.com.devergente.enuns;

public enum EnunsNeuro {

        /* Tipo Neurodivergente :
    1 - TEA;
    2 - TDAH;
    3 - Dislexia;
    4 - Tourette;
    5 - Outros;
    */

    TEA(1),
    TDAH(2),
    DISLEXIA(3),
    TOURETTE(4),
    OUTROS(5);

    private final int tipoNeuro;

    EnunsNeuro(int tipoNeuro){
        this.tipoNeuro = tipoNeuro;
    }

    public int getTipoNeuro(){
        return tipoNeuro;
    }
}
