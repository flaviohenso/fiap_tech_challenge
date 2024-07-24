package com.techchallenge.techchallenge.infrastructure.input.dto.pagamento;

import com.techchallenge.techchallenge.core.entities.Pagamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PagamentoDtoMapper {
    Pagamento fromDto(PagamentoRequestDto pagamentoRequestDto);

    PagamentoRequestDto toDto(Pagamento pagamento);
}
