package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techchallenge.techchallenge.aplication.ports.output.CozinheiroOutPort;
import com.techchallenge.techchallenge.core.domain.entity.Cozinheiro;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro.repository.CozinheiroRepository;

@Component
public class CozinheiroMongoAdapter implements CozinheiroOutPort{

    private CozinheiroRepository repository;

    public CozinheiroMongoAdapter(CozinheiroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cozinheiro> getAll() {
        var cozinheiros = repository.getAll();
        return cozinheiros;
    }

    @Override
    public Cozinheiro create(Cozinheiro cozinheiro) {
        var created = repository.create(cozinheiro);
        return created;
    }
    
}
