package com.techchallenge.techchallenge.adapters.gateway.cliente;

import com.techchallenge.techchallenge.adapters.gateway.cliente.mapper.ClienteMapper;
import com.techchallenge.techchallenge.core.entities.cliente.ClienteEntity;
import com.techchallenge.techchallenge.core.exceptions.InvalidClienteException;
import com.techchallenge.techchallenge.pkg.dto.cliente.ClienteDto;
import com.techchallenge.techchallenge.pkg.interfaces.IClienteDataSource;

import java.util.List;

public class ClienteGateway {

    private final IClienteDataSource dataSource;

    public ClienteGateway(IClienteDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ClienteEntity criar(ClienteEntity cliente) {
        if (cliente.getId() != null) throw new InvalidClienteException("Cliente já existente");

        ClienteDto savedCliente = dataSource.insertCliente(ClienteMapper.toClienteDto(cliente));

        return ClienteMapper.toClienteEntity(savedCliente);
    }

    public List<ClienteEntity> findByCpf(String cpf) {
        List<ClienteDto> clientes = dataSource.findByCpf(cpf);
        
        return clientes.stream().map(ClienteMapper::toClienteEntity).toList();
    }
}
