package com.techchallenge.techchallenge.core.usecases;

import com.techchallenge.techchallenge.adapters.gateway.pagamento.PagamentoGateway;
import com.techchallenge.techchallenge.core.entities.pagamento.PagamentoEntity;
import com.techchallenge.techchallenge.core.entities.pagamento.StatusPagamento;
import com.techchallenge.techchallenge.core.exceptions.InvalidPagamentoException;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Optional;

public class PagamentoUseCaseImpl {
    private final PagamentoGateway pagamentoGateway;

    public PagamentoUseCaseImpl(
            PagamentoGateway pagamentoGateway
    ) {
        this.pagamentoGateway = pagamentoGateway;
    }

    public PagamentoEntity criar(String pedidoId, BigDecimal valor, String externalId) {
        validatePagamentoCreation(pedidoId);

        PagamentoEntity pagamento = toPagamentoEntity(pedidoId, valor, externalId);
        return pagamentoGateway.criarPagamento(pagamento);
    }

    private void validatePagamentoCreation(String pedidoId) {
        PagamentoEntity savedPagamento = pagamentoGateway.consultarByPedidoId(pedidoId);

        if (savedPagamento != null && savedPagamento.getStatus() == StatusPagamento.PENDENTE) {
            throw new InvalidPagamentoException("pedido já possui um pagamento pendente");
        }

        if (savedPagamento != null && savedPagamento.getStatus() == StatusPagamento.APROVADO) {
            throw new InvalidPagamentoException("pedido já possui um pagamento aprovado");
        }
    }

    private PagamentoEntity toPagamentoEntity(String pedidoId, BigDecimal valor, String externalId) {
        OffsetDateTime now = OffsetDateTime.now();
        return new PagamentoEntity(
                null,
                externalId,
                pedidoId,
                valor,
                StatusPagamento.PENDENTE,
                null,
                now,
                now
        );
    }

    public PagamentoEntity consultarByPedidoId(String pedidoId) {
        return Optional.ofNullable(pedidoId)
                .map(pagamentoGateway::consultarByPedidoId)
                .orElseThrow(() -> new InvalidPagamentoException("pagamento para pedido nao encontrado"));
    }

    public PagamentoEntity callbackPagamento(String externalId, StatusPagamento status) {
        PagamentoEntity pagamento = Optional.ofNullable(externalId)
                .map(pagamentoGateway::consultarByExternalId)
                .orElseThrow(() -> new InvalidPagamentoException("pagamento para external id nao encontrado"));

        if (status != null) {
            OffsetDateTime now = OffsetDateTime.now();
            pagamento.setStatus(status);
            pagamento.setPagamentoConfirmadoAt(now);
            pagamento.setUpdatedAt(now);
            pagamentoGateway.atualizarPagamento(pagamento);
        }

        return pagamento;
    }
}
