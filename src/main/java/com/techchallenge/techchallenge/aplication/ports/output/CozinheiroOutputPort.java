package com.techchallenge.techchallenge.aplication.ports.output;

import java.util.List;

import com.techchallenge.techchallenge.core.domain.entity.Cozinheiro;

public interface CozinheiroOutputPort {

    public List<Cozinheiro> getAll();
    public Cozinheiro create(Cozinheiro cozinheiro) ;    
}