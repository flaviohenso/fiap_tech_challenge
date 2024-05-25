package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.mapper;

import org.mapstruct.Mapper;

import com.techchallenge.techchallenge.core.domain.entity.Pagamento;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.entity.PagamentoEntity;

@Mapper(componentModel = "spring")
public interface PagamentoEntityMapper {
    PagamentoEntity toEntity(Pagamento pagamento);

    Pagamento fromEntity(PagamentoEntity destinatio);
}
