package com.techchallenge.techchallenge.usecases;

import com.techchallenge.techchallenge.domain.entity.Cozinheiro;
import com.techchallenge.techchallenge.repositories.ICozinheiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CozinheiroUseCases {

    final private ICozinheiroRepository repository;

    public CozinheiroUseCases(ICozinheiroRepository repository) {
        this.repository = repository;
    }

    public List<Cozinheiro> findAll() {
        return repository.getAll();
    }

    public Cozinheiro create(Cozinheiro cozinheiro) {
        cozinheiro.setId(UUID.randomUUID());
        return repository.create(cozinheiro);
    }
}
