package com.serasa.experian.HotelExperian.enums;

import lombok.Getter;

@Getter
public enum VagaDeGaragem {
    VAGA_SEMANA("Para esta vaga na garagem do hotel há um acréscimo diário R$ 15,00 ",
            15),
    VAGA_FIM_DE_SEMANA("Para esta vaga na garagem do hotel há um acréscimo diário R$ 20,00 ",
            20);
    private String descricao;
    private double valor;

    VagaDeGaragem(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
}
