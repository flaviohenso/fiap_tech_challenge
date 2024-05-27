package com.techchallenge.techchallenge.aplication.ports.output;

import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;

import java.util.List;

public interface PedidoOutputPort {
    Pedido criarPedido(Pedido pedido);

    List<Pedido> findAll(String status);
}
