package com.techchallenge.techchallenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CpfAlreadySavedException extends ResponseStatusException {
    public CpfAlreadySavedException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "client with same cpf already saved");
    }
}