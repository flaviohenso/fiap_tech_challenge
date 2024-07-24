package com.techchallenge.techchallenge.adapters.controller;

import com.techchallenge.techchallenge.adapters.gateway.PedidoGateway;
import com.techchallenge.techchallenge.core.entities.pedido.PedidoEntity;
import com.techchallenge.techchallenge.core.entities.pedido.PedidoStatus;
import com.techchallenge.techchallenge.core.requests.CriarPedidoDto;
import com.techchallenge.techchallenge.core.usecases.PedidoUseCase;
import com.techchallenge.techchallenge.pkg.interfaces.IPedidoDataSource;

import java.util.List;

public class PedidoController {
    private final IPedidoDataSource dataSource;

    public PedidoController(IPedidoDataSource dataSource) {
        this.dataSource = dataSource;
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
}
