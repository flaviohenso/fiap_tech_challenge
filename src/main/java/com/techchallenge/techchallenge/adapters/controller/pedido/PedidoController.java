package com.techchallenge.techchallenge.adapters.controller.pedido;

import com.techchallenge.techchallenge.adapters.gateway.pagamento.PagamentoGateway;
import com.techchallenge.techchallenge.adapters.gateway.pedido.PedidoGateway;
import com.techchallenge.techchallenge.core.entities.pagamento.PagamentoEntity;
import com.techchallenge.techchallenge.core.entities.pedido.PedidoEntity;
import com.techchallenge.techchallenge.core.entities.pedido.PedidoStatus;
import com.techchallenge.techchallenge.core.exceptions.PedidoNotFoundException;
import com.techchallenge.techchallenge.core.requests.pedido.CriarPedidoDto;
import com.techchallenge.techchallenge.core.usecases.PagamentoUseCaseImpl;
import com.techchallenge.techchallenge.core.usecases.PedidoUseCase;
import com.techchallenge.techchallenge.pkg.interfaces.IPagamentoDataSource;
import com.techchallenge.techchallenge.pkg.interfaces.IPedidoDataSource;

import java.util.List;
import java.util.Optional;

public class PedidoController {
    private final IPedidoDataSource dataSource;
    private final IPagamentoDataSource pagamentoDataSource;

    public PedidoController(IPedidoDataSource dataSource, IPagamentoDataSource pagamentoDataSource) {
        this.dataSource = dataSource;
        this.pagamentoDataSource = pagamentoDataSource;
    }

    public PedidoEntity cadastrarPedido(CriarPedidoDto criarPedidoDto) {
        PedidoGateway pedidoGateway = new PedidoGateway(dataSource);
        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway);

        return pedidoUseCase.criarPedido(criarPedidoDto);
    }

    public PedidoEntity atualizarStatus(String id, PedidoStatus status) {
        PedidoGateway pedidoGateway = new PedidoGateway(dataSource);
        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway);

        return pedidoUseCase.atualizarStatus(id, status);
    }

    public PedidoEntity getById(String id) {
        PedidoGateway pedidoGateway = new PedidoGateway(dataSource);
        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway);
        return pedidoUseCase.buscarPorId(id);
    }

    public List<PedidoEntity> getAll() {
        PedidoGateway pedidoGateway = new PedidoGateway(dataSource);
        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway);
        return pedidoUseCase.buscarTodos();
    }

    public PagamentoEntity getPedidoPagamentoByPedidoId(String pedidoId) {
        PedidoGateway pedidoGateway = new PedidoGateway(dataSource);
        PedidoUseCase pedidoUseCase = new PedidoUseCase(pedidoGateway);
        PedidoEntity pedidoEntity = Optional.ofNullable(pedidoId)
                .map(pedidoUseCase::buscarPorId)
                .orElseThrow(PedidoNotFoundException::new);

        PagamentoGateway pagamentoGateway = new PagamentoGateway(pagamentoDataSource);
        PagamentoUseCaseImpl pagamentoUseCase = new PagamentoUseCaseImpl(pagamentoGateway);
        return pagamentoUseCase.consultarByPedidoId(pedidoEntity.getId());
    }
}
