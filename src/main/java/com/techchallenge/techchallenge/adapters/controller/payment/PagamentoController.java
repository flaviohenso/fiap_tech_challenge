package com.techchallenge.techchallenge.adapters.controller.payment;

import com.techchallenge.techchallenge.adapters.gateway.pagamento.PagamentoGateway;
import com.techchallenge.techchallenge.adapters.gateway.pagamento.PaymentProcessorGateway;
import com.techchallenge.techchallenge.adapters.gateway.pedido.PedidoGateway;
import com.techchallenge.techchallenge.core.entities.pagamento.ExternalPagamentoEntity;
import com.techchallenge.techchallenge.core.entities.pagamento.PagamentoEntity;
import com.techchallenge.techchallenge.core.entities.pagamento.StatusPagamento;
import com.techchallenge.techchallenge.core.entities.pedido.PedidoEntity;
import com.techchallenge.techchallenge.core.entities.pedido.PedidoStatus;
import com.techchallenge.techchallenge.core.requests.CriarPagamentoDto;
import com.techchallenge.techchallenge.core.usecases.PagamentoProcessorUseCase;
import com.techchallenge.techchallenge.core.usecases.PagamentoUseCaseImpl;
import com.techchallenge.techchallenge.core.usecases.PedidoUseCase;
import com.techchallenge.techchallenge.pkg.interfaces.IPagamentoDataSource;
import com.techchallenge.techchallenge.pkg.interfaces.IPaymentProcessorWebClient;
import com.techchallenge.techchallenge.pkg.interfaces.IPedidoDataSource;

public class PagamentoController {
    private final IPedidoDataSource pedidoDataSource;
    private final IPagamentoDataSource pagamentoDataSource;
    private final IPaymentProcessorWebClient paymentProcessorWebClient;

    public PagamentoController(
            IPedidoDataSource pedidoDataSource,
            IPagamentoDataSource pagamentoDataSource,
            IPaymentProcessorWebClient paymentProcessorWebClient
    ) {
        this.pedidoDataSource = pedidoDataSource;
        this.pagamentoDataSource = pagamentoDataSource;
        this.paymentProcessorWebClient = paymentProcessorWebClient;
    }

    public PagamentoEntity pagamentoStatusCallback(String externalId) {
        PaymentProcessorGateway paymentProcessorGateway = new PaymentProcessorGateway(paymentProcessorWebClient);
        PagamentoProcessorUseCase pagamentoProcessorUseCase = new PagamentoProcessorUseCase(paymentProcessorGateway);
        StatusPagamento status = pagamentoProcessorUseCase.consultarStatusPagamento(externalId);

        PagamentoGateway pagamentoGateway = new PagamentoGateway(pagamentoDataSource);
        PagamentoUseCaseImpl pagamentoUseCase = new PagamentoUseCaseImpl(pagamentoGateway);
        PagamentoEntity pagamento = pagamentoUseCase.callbackPagamento(externalId, status);

        PedidoGateway pedidoGateway = new PedidoGateway(pedidoDataSource);
        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway);
        pedidoUseCase.atualizarStatus(pagamento.getPedidoId(), PedidoStatus.RECEBIDO);

        return pagamento;
    }

    public PagamentoEntity criarPagamento(CriarPagamentoDto dto) {
        PedidoGateway pedidoGateway = new PedidoGateway(pedidoDataSource);
        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway);
        PedidoEntity pedido = pedidoUseCase.buscarPorId(dto.getPedidoId());

        PaymentProcessorGateway paymentProcessorGateway = new PaymentProcessorGateway(paymentProcessorWebClient);
        PagamentoProcessorUseCase pagamentoProcessorUseCase = new PagamentoProcessorUseCase(paymentProcessorGateway);
        ExternalPagamentoEntity externalPagamento = pagamentoProcessorUseCase.criar(pedido.getTotalPrice());

        PagamentoGateway pagamentoGateway = new PagamentoGateway(pagamentoDataSource);
        PagamentoUseCaseImpl pagamentoUseCase = new PagamentoUseCaseImpl(pagamentoGateway);
        return pagamentoUseCase.criar(pedido.getId(), pedido.getTotalPrice(), externalPagamento.getExternalId());
    }
}
