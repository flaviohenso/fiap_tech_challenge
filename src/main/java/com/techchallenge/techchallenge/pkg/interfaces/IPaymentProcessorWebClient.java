package com.techchallenge.techchallenge.pkg.interfaces;

import com.techchallenge.techchallenge.core.entities.pagamento.StatusPagamento;

import java.math.BigDecimal;

public interface IPaymentProcessorWebClient {
    String criarPagamento(BigDecimal valor);

    StatusPagamento consultarStatusPagamento(String externalId);
}
