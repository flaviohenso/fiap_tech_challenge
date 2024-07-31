package com.techchallenge.techchallenge.core.requests;

import java.math.BigDecimal;

public class CriarPagamentoDto {
    private String pedidoId;

    public CriarPagamentoDto(
            String pedidoId,
            BigDecimal valor
    ) {
        this.pedidoId = pedidoId;
    }

    public String getPedidoId() {
        return pedidoId;
    }
}
