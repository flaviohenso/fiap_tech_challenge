package com.techchallenge.techchallenge.core.domain.dto;

import org.mapstruct.Mapper;

import com.techchallenge.techchallenge.core.domain.entity.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteDtoMapper {
    Cliente fromDto(UpsertClienteRequestDto clienteDto);

    UpsertClienteRequestDto toDto(Cliente cliente);
}
