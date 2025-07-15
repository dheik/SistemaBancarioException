package com.meubanco.exception;

public class ContaNaoEncontradaException extends Exception {
    public ContaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}