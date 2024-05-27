package com.techchallenge.techchallenge.aplication.ports.output;

import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;

public interface PedidoOutputPort {
    Pedido criarPedido(Pedido pedido);
}
