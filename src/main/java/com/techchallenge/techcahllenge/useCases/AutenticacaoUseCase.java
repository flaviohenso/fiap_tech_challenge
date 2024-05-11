package com.techchallenge.techcahllenge.useCases;

import com.techchallenge.techcahllenge.domain.entite.Cliente;

public class AutenticacaoUseCase {

    /**
     * Método responsável por autenticar o cliente
     * @param cliente
     * @return
     */
    public boolean autenticarCliente(Cliente cliente) {
        return cliente.getCpf() != null;
    }

}
