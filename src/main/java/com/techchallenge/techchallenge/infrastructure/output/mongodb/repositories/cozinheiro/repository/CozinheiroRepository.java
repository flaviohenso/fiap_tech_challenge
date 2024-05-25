package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techchallenge.techchallenge.core.domain.entity.Cozinheiro;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro.mappers.CozinheiroEntityMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CozinheiroRepository implements ICozinheiroRepository {

    private final CozinheiroEntityMapper mapper;

    private final MongoCozinheiroRepository repository;

    @Override
    public List<Cozinheiro> getAll() {
        return repository.findAll().stream().map(mapper::fromEntity).toList();
    }

    @Override
    public Cozinheiro create(Cozinheiro cozinheiro) {
        return mapper.fromEntity(
                repository.save(mapper.toEntity(cozinheiro))
        );
    }
}
