package com.techchallenge.techchallenge.adapters.gateway.cliente.mapper;

import com.techchallenge.techchallenge.core.entities.cliente.ClienteEntity;
import com.techchallenge.techchallenge.pkg.dto.cliente.ClienteDto;

public class ClienteMapper {
    public static ClienteDto toClienteDto(ClienteEntity cliente) {
        return new ClienteDto(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getCreatedAt(),
                cliente.getUpdatedAt()
        );
    }

    public static ClienteEntity toClienteEntity(ClienteDto cliente) {
        return new ClienteEntity(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getCreatedAt(),
                cliente.getUpdatedAt()
        );
    }
}
