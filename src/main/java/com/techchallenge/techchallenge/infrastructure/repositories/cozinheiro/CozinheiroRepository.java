package com.techchallenge.techchallenge.infrastructure.repositories.cozinheiro;

import com.techchallenge.techchallenge.core.domain.entity.Cozinheiro;
import com.techchallenge.techchallenge.infrastructure.repositories.cozinheiro.entity.CozinheiroEntityMapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
