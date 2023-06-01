package com.serasa.experian.HotelExperian.enums;

public enum Diaria {
    FIM_DE_SEMANA("Fim de Semana", 150.0),
    SEMANA("Semana", 120.0);
    private String descricao;
    private double valor;

    private Diaria(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
}
