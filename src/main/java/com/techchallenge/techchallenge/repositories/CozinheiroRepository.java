package com.techchallenge.techchallenge.repositories;

import com.techchallenge.techchallenge.domain.entity.Cozinheiro;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CozinheiroRepository implements ICozinheiroRepository {

    private final MongoCozinheiroRepository repository;

    public CozinheiroRepository(MongoCozinheiroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cozinheiro> getAll() {
        return repository.findAll();
    }

    @Override
    public Cozinheiro create(Cozinheiro cozinheiro) {
        return repository.save(cozinheiro);
    }
}
