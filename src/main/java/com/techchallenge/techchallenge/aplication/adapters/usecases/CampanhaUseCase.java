package com.techchallenge.techchallenge.aplication.adapters.usecases;

import com.techchallenge.techchallenge.domain.entity.Campanha;
import com.techchallenge.techchallenge.domain.entity.Cliente;

public class CampanhaUseCase {

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
