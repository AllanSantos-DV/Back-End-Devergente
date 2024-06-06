package br.com.devergente.enuns;

public enum EnumFamiliar {

        /* Tipo Familiar :
    1 - Pai/Mãe
    2 - Filho/Filha
    3 - Irmão/Irmã
    4 - Marido/Esposa
    5 - Namorado/Namorada
    */

    PAI_MAE(1),
    FILHO_FILHA(2),
    IRMAO_IRMA(3),
    MARIDO_ESPOSA(4),
    NAMORADO_NAMORADA(5);

    private final int tipoFamiliar;

    EnumFamiliar(int tipoFamiliar){
        this.tipoFamiliar = tipoFamiliar;
    }

    public int getTipoFamiliar(){
        return tipoFamiliar;
    }
}
