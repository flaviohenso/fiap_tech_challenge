package com.techchallenge.techchallenge.core.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import com.techchallenge.techchallenge.core.domain.vo.StatusPagamento;

/**
 * Pagamento
 * com o padrão builder
 */
public class Pagamento {

    private UUID id;
    private String numeroPedido;
    private BigDecimal valor;
    private String observacao;
    private Date dataPagamento;
    private String idCliente;
    private String canal;
    private StatusPagamento status;

    public Pagamento() {
    }

    private Pagamento(Builder builder) {
        this.id = builder.id;
        this.valor = builder.valor;
        this.observacao = builder.observacao;
        this.dataPagamento = builder.dataPagamento;
        this.idCliente = builder.idCliente;
        this.canal = builder.canal;
        this.numeroPedido = builder.numeroPedido;
        this.status = builder.status;
    }

    public UUID getId() {
        return id;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getCanal() {
        return canal;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    /**
     * Builder class for creating instances of the Pagamento class.
     * Allows for convenient and flexible construction of Pagamento objects.
     */
    public static class Builder {
        private UUID id;
        private String numeroPedido;
        private BigDecimal valor;
        private String observacao;
        private Date dataPagamento;
        private String idCliente;
        private String canal;
        private StatusPagamento status;

        /**
         * Sets the id of the Pagamento entity.
         *
         * @param id The UUID to set.
         * @return The Builder instance.
         */
        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        /**
         * Genaerates a random UUID for the id field.
         *
         * @param valor The UUID to set.
         * @return The Builder instance.
         */
        public Builder withIdRandom() {
            this.id = UUID.randomUUID();
            return this;
        }

        /**
         * Sets the numeroPedido of the Pagamento entity.
         *
         * @param valor The numeroPedido to set.
         * @return The Builder instance.
         */
        public Builder withNumeroPedido(String numeroPedido) {
            this.numeroPedido = numeroPedido;
            return this;
        }

        /**
         * Sets the valor of the Pagamento entity.
         *
         * @param valor The valor to set.
         * @return The Builder instance.
         */
        public Builder withValor(BigDecimal valor) {
            this.valor = valor;
            return this;
        }

        /**
         * Sets the observacao field of the Pagamento entity.
         *
         * @param observacao The observacao value to set.
         * @return The Builder instance.
         */
        public Builder withObservacao(String observacao) {
            this.observacao = observacao;
            return this;
        }

        /**
         * Sets the dataPagamento property of the {@link Pagamento} object being built.
         * 
         * @param dataPagamento The dataPagamento value to set
         * @return The builder instance
         */
        public Builder withDataPagamento(Date dataPagamento) {
            this.dataPagamento = dataPagamento;
            return this;
        }

        /**
         * Builder pattern for creating instances of the Pagamento class.
         * 
         * @param idCliente
         * @return The builder instance
         */
        public Builder withIdCliente(String idCliente) {
            this.idCliente = idCliente;
            return this;
        }

        /**
         * Builder pattern implementation for creating instances of the Pagamento class.
         * 
         * @param canal
         * @return The builder instance
         */
        public Builder withCanal(String canal) {
            this.canal = canal;
            return this;
        }

        /**
         * Sets the status of the payment.
         * 
         * @param status
         * @return The builder instance
         */
        public Builder withStatus(StatusPagamento status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new instance of Pagamento using the values specified in the
         * Pagamento.Builder
         * 
         * @return a new instance of Pagamento
         * @see Pagamento
         */
        public Pagamento build() {
            return new Pagamento(this);
        }
    }

    /**
     * Updates the status of the payment.
     *
     * @param status the new status of the payment
     */
    public void updateStatus(StatusPagamento status) {
        this.status = status;
    }
}