package com.techchallenge.techchallenge.repositories.cozinheiro;

import com.techchallenge.techchallenge.domain.entity.Cozinheiro;

import java.util.List;

public interface ICozinheiroRepository {
    List<Cozinheiro> getAll();

    Cozinheiro create(Cozinheiro cozinheiro);
}
