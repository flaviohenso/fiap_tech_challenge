package com.techchallenge.techchallenge.aplication.ports.output;

import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoOutputPort {
    Pedido savePedido(Pedido pedido);

    List<Pedido> findAll(String status);

    Optional<Pedido> findById(String id);
}
