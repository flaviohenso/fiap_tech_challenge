package com.techchallenge.techchallenge.adapters.gateway.pagamento;

import com.techchallenge.techchallenge.core.entities.pagamento.ExternalPagamentoEntity;
import com.techchallenge.techchallenge.core.entities.pagamento.StatusPagamento;
import com.techchallenge.techchallenge.pkg.interfaces.IPaymentProcessorWebClient;

import java.math.BigDecimal;
import java.util.Optional;

public class PaymentProcessorGateway {

    private final IPaymentProcessorWebClient datasource;

    public PaymentProcessorGateway(IPaymentProcessorWebClient datasource) {
        this.datasource = datasource;
    }

    public ExternalPagamentoEntity criarPagamento(BigDecimal valor) {
        return Optional.of(valor)
                .map(datasource::criarPagamento)
                .map(externalId -> new ExternalPagamentoEntity(externalId, valor))
                .orElseThrow();
    }

    public StatusPagamento consultarStatusPagamento(String externalId) {
        return datasource.consultarStatusPagamento(externalId);
    }
}
