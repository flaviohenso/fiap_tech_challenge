package com.techchallenge.techchallenge.core.vo;

/**
 * StatusPagamento
 * Enum para status de pagamento
 * Fornece um método para retorna o valor do status
 */
public enum StatusPagamento {
    PENDENTE("PENDENTE"),
    APROVADO("APROVADO"),
    REJEITADO("CANCELADO"),
    PAGO("PAGO");

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
