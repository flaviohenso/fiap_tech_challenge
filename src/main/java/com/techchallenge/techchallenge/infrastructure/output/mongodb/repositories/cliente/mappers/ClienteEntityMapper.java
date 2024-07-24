package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.mappers;

import com.techchallenge.techchallenge.core.entities.Cliente;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.entity.ClienteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {
    ClienteEntity toEntity(Cliente cliente);

    Cliente fromEntity(ClienteEntity clienteEntity);
}
