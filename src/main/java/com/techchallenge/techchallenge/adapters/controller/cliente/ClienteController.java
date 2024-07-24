package com.techchallenge.techchallenge.adapters.controller.cliente;

import com.techchallenge.techchallenge.adapters.gateway.cliente.ClienteGateway;
import com.techchallenge.techchallenge.core.entities.cliente.ClienteEntity;
import com.techchallenge.techchallenge.core.requests.cliente.CriarClienteDto;
import com.techchallenge.techchallenge.core.usecases.ClienteUseCase;
import com.techchallenge.techchallenge.pkg.interfaces.IClienteDataSource;

public class ClienteController {
    private final IClienteDataSource dataSource;

    public ClienteController(IClienteDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ClienteEntity cadastrarCliente(CriarClienteDto criarClienteDto) {
        ClienteGateway clienteGateway = new ClienteGateway(dataSource);
        ClienteUseCase clienteUseCase = new ClienteUseCase(clienteGateway);

        return clienteUseCase.criar(criarClienteDto);
    }
}
