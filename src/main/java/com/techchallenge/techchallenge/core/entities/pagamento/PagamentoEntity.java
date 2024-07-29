package com.techchallenge.techchallenge.core.entities.pagamento;

import com.techchallenge.techchallenge.core.exceptions.InvalidPagamentoException;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class PagamentoEntity {
    private String id;
    private String externalId;
    private String pedidoId;
    private BigDecimal valor;
    private StatusPagamento status;
    private OffsetDateTime pagamentoConfirmadoAt;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public PagamentoEntity(
            String id,
            String externalId,
            String pedidoId,
            BigDecimal valor,
            StatusPagamento status,
            OffsetDateTime pagamentoConfirmadoAt,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt
    ) {
        validate(pedidoId, externalId, valor, status);

        this.id = id;
        this.externalId = externalId;
        this.pedidoId = pedidoId;
        this.valor = valor;
        this.status = status;
        this.pagamentoConfirmadoAt = pagamentoConfirmadoAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private void validate(
            String pedidoId,
            String externalId,
            BigDecimal valor,
            StatusPagamento status
    ) {
        if (pedidoId == null || pedidoId.trim().isEmpty()) {
            throw new InvalidPagamentoException("O pedido_id não pode ser nulo ou vazio.");
        }

        validateExternalId(externalId);

        if (valor == null) {
            throw new InvalidPagamentoException("O valor não pode ser nulo.");
        }

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPagamentoException("O valor deve ser maior que zero.");
        }

        if (status == null) {
            throw new InvalidPagamentoException("O status não pode ser nulo.");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagamentoEntity that = (PagamentoEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getExternalId(), that.getExternalId()) && Objects.equals(getPedidoId(), that.getPedidoId()) && Objects.equals(getValor(), that.getValor()) && getStatus() == that.getStatus() && Objects.equals(getPagamentoConfirmadoAt(), that.getPagamentoConfirmadoAt()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getExternalId(), getPedidoId(), getValor(), getStatus(), getPagamentoConfirmadoAt(), getCreatedAt(), getUpdatedAt());
    }

    public void setExternalId(String externalId) {
        validateExternalId(externalId);
        this.externalId = externalId;
    }

    private void validateExternalId(String externalId) {
        if (externalId != null && externalId.trim().isEmpty()) {
            throw new InvalidPagamentoException("external_id nao informado.");
        }
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public void setPagamentoConfirmadoAt(OffsetDateTime pagamentoConfirmadoAt) {
        this.pagamentoConfirmadoAt = pagamentoConfirmadoAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
