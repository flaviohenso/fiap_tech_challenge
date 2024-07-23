package com.techchallenge.techchallenge.infrastructure.input.dto.cliente;

import com.techchallenge.techchallenge.core.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteDtoMapper {
    Cliente fromDto(ClienteRequestDto clienteDto);

    ClienteRequestDto toDto(Cliente cliente);
}
