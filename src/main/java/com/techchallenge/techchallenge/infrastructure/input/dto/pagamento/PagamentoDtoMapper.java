package com.techchallenge.techchallenge.infrastructure.input.dto.pagamento;

import org.mapstruct.Mapper;

import com.techchallenge.techchallenge.core.domain.entity.Pagamento;

@Mapper(componentModel = "spring")
public interface PagamentoDtoMapper {
    Pagamento fromDto(PagamentoRequestDto pagamentoRequestDto);
    PagamentoRequestDto toDto(Pagamento pagamento);
}
