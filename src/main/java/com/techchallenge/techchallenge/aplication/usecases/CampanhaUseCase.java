package com.techchallenge.techchallenge.aplication.usecases;

import com.techchallenge.techchallenge.core.domain.entity.Campanha;
import com.techchallenge.techchallenge.core.domain.entity.Cliente;

public abstract class CampanhaUseCase {

    private AutenticacaoUseCase autenticacaoUseCase;

    public CampanhaUseCase() {}

    public CampanhaUseCase(AutenticacaoUseCase autenticacaoUseCase) {
        this.autenticacaoUseCase = autenticacaoUseCase;
    }

    public Campanha iniciarCampanha(Cliente cliente) {
        if (autenticacaoUseCase.autenticarCliente(cliente)) {
            return new Campanha();
        }
        return null;   
    }
    
}
