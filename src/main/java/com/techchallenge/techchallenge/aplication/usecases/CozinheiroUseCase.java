package com.techchallenge.techchallenge.aplication.usecases;

import java.util.List;

import com.techchallenge.techchallenge.core.domain.entity.Cozinheiro;

/**
 * CozinheiroUseCase
 * 
 * This class represents the use case for the Cozinheiro entity.
 */
public interface CozinheiroUseCase {
    
    public List<Cozinheiro> findAll();
    public Cozinheiro create(Cozinheiro cozinheiro);
}
