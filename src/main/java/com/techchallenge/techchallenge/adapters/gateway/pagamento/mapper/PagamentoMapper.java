package com.techchallenge.techchallenge.adapters.gateway.pagamento.mapper;

import com.techchallenge.techchallenge.core.entities.pagamento.PagamentoEntity;
import com.techchallenge.techchallenge.pkg.dto.PagamentoDto;

public class PagamentoMapper {
    public static PagamentoDto toDto(PagamentoEntity pagamento) {
        return new PagamentoDto(
                pagamento.getId(),
                pagamento.getExternalId(),
                pagamento.getPedidoId(),
                pagamento.getValor(),
                pagamento.getStatus(),
                pagamento.getPagamentoConfirmadoAt(),
                pagamento.getCreatedAt(),
                pagamento.getUpdatedAt()
        );
    }

    public static PagamentoEntity toEntity(PagamentoDto pagamento) {
        return new PagamentoEntity(
                pagamento.getId(),
                pagamento.getExternalId(),
                pagamento.getPedidoId(),
                pagamento.getValor(),
                pagamento.getStatus(),
                pagamento.getPagamentoConfirmadoAt(),
                pagamento.getCreatedAt(),
                pagamento.getUpdatedAt()
        );
    }
}
