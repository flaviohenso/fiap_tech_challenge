package com.techchallenge.techchallenge.infrastructure.input.dto.pagamento;

import java.math.BigDecimal;
import java.util.Date;

public class PagamentoRequestDto {
    
    private String numeroPedido;
    private BigDecimal valor;
    private String observacao;
    private Date dataPagamento;
    private String idCliente;
    private String canal;

    public PagamentoRequestDto() {
    }

    public PagamentoRequestDto(String numeroPedido, BigDecimal valor, String observacao, Date dataPagamento,
     String idCliente, String canal) {
        this.numeroPedido = numeroPedido;
        this.valor = valor;
        this.observacao = observacao;
        this.dataPagamento = dataPagamento;
        this.idCliente = idCliente;
        this.canal = canal;
    }

    public String getNumeroPedido() {
        return this.numeroPedido;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public Date getDataPagamento() {
        return this.dataPagamento;
    }

    public String getIdCliente() {
        return this.idCliente;
    }

    public String getCanal() {
        return this.canal;
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PagamentoRequestDto)) return false;
        final PagamentoRequestDto other = (PagamentoRequestDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$numeroPedido = this.getNumeroPedido();
        final Object other$numeroPedido = other.getNumeroPedido();
        if (this$numeroPedido == null ? other$numeroPedido != null : !this$numeroPedido.equals(other$numeroPedido))
            return false;
        final Object this$valor = this.getValor();
        final Object other$valor = other.getValor();
        if (this$valor == null ? other$valor != null : !this$valor.equals(other$valor)) return false;
        final Object this$observacao = this.getObservacao();
        final Object other$observacao = other.getObservacao();
        if (this$observacao == null ? other$observacao != null : !this$observacao.equals(other$observacao))
            return false;
        final Object this$dataPagamento = this.getDataPagamento();
        final Object other$dataPagamento = other.getDataPagamento();
        if (this$dataPagamento == null ? other$dataPagamento != null : !this$dataPagamento.equals(other$dataPagamento))
            return false;
        final Object this$idCliente = this.getIdCliente();
        final Object other$idCliente = other.getIdCliente();
        if (this$idCliente == null ? other$idCliente != null : !this$idCliente.equals(other$idCliente)) return false;
        final Object this$canal = this.getCanal();
        final Object other$canal = other.getCanal();
        if (this$canal == null ? other$canal != null : !this$canal.equals(other$canal)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PagamentoRequestDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $numeroPedido = this.getNumeroPedido();
        result = result * PRIME + ($numeroPedido == null ? 43 : $numeroPedido.hashCode());
        final Object $valor = this.getValor();
        result = result * PRIME + ($valor == null ? 43 : $valor.hashCode());
        final Object $observacao = this.getObservacao();
        result = result * PRIME + ($observacao == null ? 43 : $observacao.hashCode());
        final Object $dataPagamento = this.getDataPagamento();
        result = result * PRIME + ($dataPagamento == null ? 43 : $dataPagamento.hashCode());
        final Object $idCliente = this.getIdCliente();
        result = result * PRIME + ($idCliente == null ? 43 : $idCliente.hashCode());
        final Object $canal = this.getCanal();
        result = result * PRIME + ($canal == null ? 43 : $canal.hashCode());
        return result;
    }
}
