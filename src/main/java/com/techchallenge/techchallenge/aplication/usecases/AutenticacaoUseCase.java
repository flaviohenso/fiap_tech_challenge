package com.techchallenge.techchallenge.aplication.usecases;

import com.techchallenge.techchallenge.core.domain.entity.Cliente;

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
