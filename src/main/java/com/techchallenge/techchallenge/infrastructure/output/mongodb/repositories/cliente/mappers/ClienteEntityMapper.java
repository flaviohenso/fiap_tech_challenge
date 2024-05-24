package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.mappers;

import org.mapstruct.Mapper;

import com.techchallenge.techchallenge.core.domain.entity.Cliente;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.entities.ClienteEntity;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {
    ClienteEntity toEntity(Cliente cliente);

    Cliente fromEntity(ClienteEntity clienteEntity);
}
