package com.techchallenge.techchallenge.core.exceptions;

public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(String id) {
        super(String.format("produto with id %s not found", id));
    }
}