package com.techchallenge.techchallenge.aplication.ports.input;

import com.techchallenge.techchallenge.aplication.ports.output.PedidoOutputPort;
import com.techchallenge.techchallenge.aplication.usecases.PedidoUseCase;
import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;
import com.techchallenge.techchallenge.core.domain.entity.pedido.PedidoStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class PedidoInputPort implements PedidoUseCase {

    PedidoOutputPort repository;

    public PedidoInputPort(PedidoOutputPort repository) {
        this.repository = repository;
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        pedido.setId(UUID.randomUUID().toString());
        pedido.setCreatedAt(LocalDateTime.now());
        pedido.setStatus(PedidoStatus.INICIAL);
        return repository.criarPedido(pedido);
    }
}
