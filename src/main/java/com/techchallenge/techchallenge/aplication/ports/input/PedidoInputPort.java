package com.techchallenge.techchallenge.aplication.ports.input;

import com.techchallenge.techchallenge.aplication.ports.output.PedidoOutputPort;
import com.techchallenge.techchallenge.aplication.usecases.PedidoUseCase;
import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;
import com.techchallenge.techchallenge.core.domain.entity.pedido.PedidoStatus;
import com.techchallenge.techchallenge.core.domain.exceptions.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PedidoInputPort implements PedidoUseCase {

    PedidoOutputPort repository;

    public PedidoInputPort(PedidoOutputPort repository) {
        this.repository = repository;
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        LocalDateTime now = LocalDateTime.now();
        pedido.setId(UUID.randomUUID().toString());
        pedido.setCreatedAt(now);
        pedido.setLastUpdatedAt(now);
        pedido.setStatus(PedidoStatus.INICIAL);
        return repository.savePedido(pedido);
    }

    @Override
    public List<Pedido> findAll(String status) {
        return repository.findAll(status);
    }

    @Override
    public Pedido updateStatus(String id, PedidoStatus status) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("pedido with id %s not found", id)));

        pedido.setLastUpdatedAt(LocalDateTime.now());
        pedido.setStatus(status);

        return repository.savePedido(pedido);
    }
}
