package com.techchallenge.techchallenge.infrastructure.input.dto.cliente;

import org.mapstruct.Mapper;

import com.techchallenge.techchallenge.core.domain.entity.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteDtoMapper {
    Cliente fromDto(ClienteRequestDto clienteDto);
    ClienteRequestDto toDto(Cliente cliente);
}
