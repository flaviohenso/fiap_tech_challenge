package com.techchallenge.techchallenge.pkg.dto;

import com.techchallenge.techchallenge.core.entities.pagamento.StatusPagamento;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class PagamentoDto {
    private String id;
    private String externalId;
    private String pedidoId;
    private BigDecimal valor;
    private StatusPagamento status;
    private OffsetDateTime pagamentoConfirmadoAt;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public PagamentoDto(
            String id,
            String externalId,
            String pedidoId,
            BigDecimal valor,
            StatusPagamento status,
            OffsetDateTime pagamentoConfirmadoAt,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt
    ) {
        this.id = id;
        this.externalId = externalId;
        this.pedidoId = pedidoId;
        this.valor = valor;
        this.status = status;
        this.pagamentoConfirmadoAt = pagamentoConfirmadoAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public OffsetDateTime getPagamentoConfirmadoAt() {
        return pagamentoConfirmadoAt;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(String id) {
        this.id = id;
    }
}
