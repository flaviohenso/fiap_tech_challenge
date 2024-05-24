package com.techchallenge.techchallenge.aplication.ports.input;

import java.util.List;
import java.util.UUID;

import com.techchallenge.techchallenge.aplication.usecases.CozinheiroUseCase;
import com.techchallenge.techchallenge.core.domain.entity.Cozinheiro;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro.ICozinheiroRepository;

/**
 * ClienteInputPort
 * 
 * This class represents the input port for the Cliente entity.
 */
//@service
public class CozinheiroInputPort implements CozinheiroUseCase{

    final private ICozinheiroRepository repository;

    public CozinheiroInputPort(ICozinheiroRepository repository) {
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
