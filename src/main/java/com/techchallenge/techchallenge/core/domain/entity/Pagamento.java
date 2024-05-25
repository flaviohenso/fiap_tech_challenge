package com.techchallenge.techchallenge.core.domain.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import com.techchallenge.techchallenge.core.domain.vo.StatusPagamento;

import lombok.AllArgsConstructor;
import lombok.Data;

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

    public static class Builder {
        private UUID id;
        private String numeroPedido;
        private BigDecimal valor;
        private String observacao;
        private Date dataPagamento;
        private String idCliente;
        private String canal;
        private StatusPagamento status;

        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder withNumeroPedido(String numeroPedido) {
            this.numeroPedido = numeroPedido;
            return this;
        }

        public Builder withValor(BigDecimal valor) {
            this.valor = valor;
            return this;
        }

        public Builder withObservacao(String observacao) {
            this.observacao = observacao;
            return this;
        }

        public Builder withDataPagamento(Date dataPagamento) {
            this.dataPagamento = dataPagamento;
            return this;
        }

        public Builder withIdCliente(String idCliente) {
            this.idCliente = idCliente;
            return this;
        }

        public Builder withCanal(String canal) {
            this.canal = canal;
            return this;
        }

        public Builder withStatus(StatusPagamento status) {
            this.status = status;
            return this;
        }

        public Pagamento build() {
            return new Pagamento(this);
        }
    }

    //atualiza status do pagamento
    public void updateStatus(StatusPagamento status) {
        this.status = status;
    }
}