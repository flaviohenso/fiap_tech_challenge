package com.techchallenge.techchallenge.external.webclient;

import com.techchallenge.techchallenge.core.entities.pagamento.StatusPagamento;
import com.techchallenge.techchallenge.pkg.interfaces.IPaymentProcessorWebClient;

import java.math.BigDecimal;
import java.util.UUID;

public class MercadoPagoPaymentProcessorWebClient implements IPaymentProcessorWebClient {
    private final String callBackUrl; //"mydomain.sample.com/callback-mercadopago";

    public MercadoPagoPaymentProcessorWebClient(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    @Override
    public String criarPagamento(BigDecimal valor) {
        return UUID.randomUUID().toString();
    }

    @Override
    public StatusPagamento consultarStatusPagamento(String externalId) {
        return StatusPagamento.APROVADO;
    }
}
