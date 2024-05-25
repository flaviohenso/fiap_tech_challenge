package com.techchallenge.techchallenge.aplication.ports.input;

import java.util.List;
import java.util.UUID;

import com.techchallenge.techchallenge.aplication.ports.output.CozinheiroOutPort;
import com.techchallenge.techchallenge.aplication.usecases.CozinheiroUseCase;
import com.techchallenge.techchallenge.core.domain.entity.Cozinheiro;

/**
 * ClienteInputPort
 * 
 * This class represents the input port for the Cliente entity.
 */
public class CozinheiroInputPort implements CozinheiroUseCase{

    private CozinheiroOutPort repository;

    public CozinheiroInputPort(CozinheiroOutPort repository) {
        this.repository = repository;
    }

    @Override
    public Cozinheiro create(Cozinheiro cozinheiro) {
        cozinheiro.setId(UUID.randomUUID());
        return repository.create(cozinheiro);
    }

    @Override
    public List<Cozinheiro> findAll() {
        return repository.getAll();
    }
}
