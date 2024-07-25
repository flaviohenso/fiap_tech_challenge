package com.techchallenge.techchallenge.adapters.controller.cliente;

import com.techchallenge.techchallenge.adapters.gateway.cliente.ClienteGateway;
import com.techchallenge.techchallenge.core.entities.cliente.ClienteEntity;
import com.techchallenge.techchallenge.core.requests.cliente.AtualizarClienteDto;
import com.techchallenge.techchallenge.core.requests.cliente.CriarClienteDto;
import com.techchallenge.techchallenge.core.usecases.ClienteUseCase;
import com.techchallenge.techchallenge.pkg.interfaces.IClienteDataSource;

import java.util.List;

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

    public List<ClienteEntity> buscarTodos(String cpf) {
        ClienteGateway clienteGateway = new ClienteGateway(dataSource);
        ClienteUseCase clienteUseCase = new ClienteUseCase(clienteGateway);

        return clienteUseCase.buscarTodos(cpf);
    }

    public void deletar(String id) {
        ClienteGateway clienteGateway = new ClienteGateway(dataSource);
        ClienteUseCase clienteUseCase = new ClienteUseCase(clienteGateway);

        clienteUseCase.deletar(id);
    }

    public ClienteEntity getById(String id) {
        ClienteGateway clienteGateway = new ClienteGateway(dataSource);
        ClienteUseCase clienteUseCase = new ClienteUseCase(clienteGateway);

        return clienteUseCase.buscarPorId(id);
    }

    public ClienteEntity atualizar(String id, AtualizarClienteDto dto) {
        ClienteGateway clienteGateway = new ClienteGateway(dataSource);
        ClienteUseCase clienteUseCase = new ClienteUseCase(clienteGateway);

        return clienteUseCase.atualizar(id, dto);
    }
}
