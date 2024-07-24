package com.techchallenge.techchallenge.core.usecases;

import com.techchallenge.techchallenge.adapters.gateway.cliente.ClienteGateway;
import com.techchallenge.techchallenge.core.entities.cliente.ClienteEntity;
import com.techchallenge.techchallenge.core.requests.cliente.CriarClienteDto;

import java.time.OffsetDateTime;

public class ClienteUseCase {
    private final ClienteGateway clienteGateway;

    public ClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public ClienteEntity criar(CriarClienteDto criarClienteDto) {
        var cliente = toClienteEntity(criarClienteDto);
        return clienteGateway.criar(cliente);
    }

    private ClienteEntity toClienteEntity(CriarClienteDto criarClienteDto) {
        OffsetDateTime now = OffsetDateTime.now();
        return new ClienteEntity(
                null,
                criarClienteDto.getNome(),
                criarClienteDto.getCpf(),
                criarClienteDto.getEmail(),
                criarClienteDto.getTelefone(),
                now,
                now
        );
    }

}
