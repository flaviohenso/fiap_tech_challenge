package com.techchallenge.techchallenge.core.domain.dto;

import org.mapstruct.Mapper;

import com.techchallenge.techchallenge.core.domain.entity.Cliente;
import com.techchallenge.techchallenge.core.domain.entity.Pagamento;

@Mapper(componentModel = "spring")
public interface PagamentoDtoMapper {
    Cliente fromDto(PagamentoRequestDto pagamentoRequestDto);
    ClienteRequestDto toDto(Pagamento pagamento);
}
