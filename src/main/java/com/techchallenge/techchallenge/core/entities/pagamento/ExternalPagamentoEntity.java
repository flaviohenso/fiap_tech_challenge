package com.techchallenge.techchallenge.core.entities.pagamento;

import com.techchallenge.techchallenge.core.exceptions.InvalidPagamentoException;

import java.math.BigDecimal;

public class ExternalPagamentoEntity {
    private String externalId;
    private BigDecimal valor;

    public ExternalPagamentoEntity(
            String externalId,
            BigDecimal valor
    ) {
        validate(externalId, valor);

        this.externalId = externalId;
        this.valor = valor;
    }

    private void validate(
            String externalId,
            BigDecimal valor
    ) {
        validateExternalId(externalId);

        if (valor == null) {
            throw new InvalidPagamentoException("O valor não pode ser nulo.");
        }

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPagamentoException("O valor deve ser maior que zero.");
        }
    }

    public String getExternalId() {
        return externalId;
    }


    public BigDecimal getValor() {
        return valor;
    }

    private void validateExternalId(String externalId) {
        if (externalId != null && externalId.trim().isEmpty()) {
            throw new InvalidPagamentoException("external_id nao informado.");
        }
    }
}
