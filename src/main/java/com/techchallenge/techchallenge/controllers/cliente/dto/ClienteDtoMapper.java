package com.techchallenge.techchallenge.controllers.cliente.dto;

import com.techchallenge.techchallenge.domain.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteDtoMapper {
    Cliente fromDto(UpsertClienteRequestDto clienteDto);

    UpsertClienteRequestDto toDto(Cliente cliente);
}
