package com.serasa.experian.HotelExperian.config;

public class ErroValidacao {
    private String mensagem;
    public ErroValidacao(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
