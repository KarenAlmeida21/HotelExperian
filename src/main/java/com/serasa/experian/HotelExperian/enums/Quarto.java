package com.serasa.experian.HotelExperian.enums;

import lombok.Getter;

import javax.persistence.GeneratedValue;

@Getter
public enum Quarto {
    STANDARD("É o tipo de quarto mais básico oferecido pelo hotel", 1),
    DELUXE("É upgrade em relação ao quarto standard, oferecendo comodidades " +
            "e serviços extras", 2),
    FAMILIA("É um tipo de quarto projetado para acomodar famílias ou grupos maiores", 5);
    private String descricao;
    private int quantidadeDeHospede;

    private Quarto(String descricao, int quantidadeDeHospede) {
        this.descricao = descricao;
        this.quantidadeDeHospede = quantidadeDeHospede;
    }
}
