package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.mapper;

import com.techchallenge.techchallenge.core.entities.Pagamento;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.entity.PagamentoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PagamentoEntityMapper {
    PagamentoEntity toEntity(Pagamento pagamento);

    Pagamento fromEntity(PagamentoEntity destinatio);
}
