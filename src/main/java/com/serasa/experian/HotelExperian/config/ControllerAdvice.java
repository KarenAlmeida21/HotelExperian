package com.serasa.experian.HotelExperian.config;

import com.serasa.experian.HotelExperian.exceptions.*;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<ErroValidacao> tratarErrosDeValidacao(MethodArgumentNotValidException excecao) {
        List<ErroValidacao> erros = new ArrayList<>();

        for (FieldError referencia : excecao.getFieldErrors()) {
            ErroValidacao erroValidacao = new ErroValidacao(referencia.getDefaultMessage(), excecao.getMessage() );
            erros.add(erroValidacao);
        }
        return erros;
    }

    @ExceptionHandler(CheckInNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMessage ErrorMessage(CheckInNaoEncontradoException exception){
        return new ErrorMessage((exception.getMessage()));

    }

    @ExceptionHandler(HospedeErrorException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMessage ErrorMessage(HospedeErrorException exception){
        return new ErrorMessage((exception.getMessage()));
    }

    @ExceptionHandler(HospedeNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage ErrorMessage(HospedeNaoEncontradoException exception){
        return new ErrorMessage((exception.getMessage()));

    }

    @ExceptionHandler(HospedeJaCadastradoException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage ErrorMessage(HospedeJaCadastradoException exception){
        return new ErrorMessage((exception.getMessage()));

    }

    @ExceptionHandler(CheckoutNãoEncontrado.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMessage ErrorMessage(CheckoutNãoEncontrado exception){
        return new ErrorMessage((exception.getMessage()));

    }
}
