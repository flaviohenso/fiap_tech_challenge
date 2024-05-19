package com.techchallenge.techchallenge.repositories.cliente.entities;

import com.techchallenge.techchallenge.domain.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {
    ClienteEntity toEntity(Cliente cliente);

    Cliente fromEntity(ClienteEntity clienteEntity);
}
