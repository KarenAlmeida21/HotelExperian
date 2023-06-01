package com.serasa.experian.HotelExperian.exceptions;

public class CheckInNaoEncontradoException extends RuntimeException {
    public CheckInNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
