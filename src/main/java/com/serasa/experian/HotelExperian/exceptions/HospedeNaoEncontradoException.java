package com.serasa.experian.HotelExperian.exceptions;

public class HospedeNaoEncontradoException extends RuntimeException{
    public HospedeNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
