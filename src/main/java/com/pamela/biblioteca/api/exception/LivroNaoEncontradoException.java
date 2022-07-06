package com.pamela.biblioteca.api.exception;

public class LivroNaoEncontradoException extends Exception {
    public LivroNaoEncontradoException(final String message) {
        super(message);
    }
}
