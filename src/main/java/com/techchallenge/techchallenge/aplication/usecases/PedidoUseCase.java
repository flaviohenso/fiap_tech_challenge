package com.techchallenge.techchallenge.aplication.usecases;

import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;
import com.techchallenge.techchallenge.core.domain.entity.pedido.PedidoStatus;

import java.util.List;

public interface PedidoUseCase {

    Pedido criarPedido(Pedido pedido);

    List<Pedido> findAll(String status);

    Pedido updateStatus(String id, PedidoStatus status);
}
