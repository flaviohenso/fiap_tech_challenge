package com.techchallenge.techcahllenge.usecases;

import com.techchallenge.techcahllenge.domain.entite.Campanha;
import com.techchallenge.techcahllenge.domain.entite.Cliente;

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
