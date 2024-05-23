package com.techchallenge.techchallenge.infrastructure.repositories.cozinheiro;

import java.util.List;

import com.techchallenge.techchallenge.core.domain.entity.Cozinheiro;

public interface ICozinheiroRepository {
    List<Cozinheiro> getAll();

    Cozinheiro create(Cozinheiro cozinheiro);
}