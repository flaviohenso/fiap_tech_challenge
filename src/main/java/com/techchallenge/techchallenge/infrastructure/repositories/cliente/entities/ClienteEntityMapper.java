package com.techchallenge.techchallenge.infrastructure.repositories.cliente.entities;

import org.mapstruct.Mapper;

import com.techchallenge.techchallenge.core.domain.entity.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {
    ClienteEntity toEntity(Cliente cliente);

    Cliente fromEntity(ClienteEntity clienteEntity);
}
