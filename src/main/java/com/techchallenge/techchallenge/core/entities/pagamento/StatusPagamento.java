package com.techchallenge.techchallenge.core.entities.pagamento;

/**
 * StatusPagamento
 * Enum para status de pagamento
 * Fornece um método para retorna o valor do status
 */
public enum StatusPagamento {
    PENDENTE("PENDENTE"),
    APROVADO("APROVADO"),
    REJEITADO("REJEITADO"),
    CANCELADO("CANCELADO");

    private String status;

    StatusPagamento(String status) {
        this.status = status;
    }

    /**
     * Retorna o valor do status
     *
     * @return status
     */
    public String getValue() {
        return status;
    }
}
