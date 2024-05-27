package com.techchallenge.techchallenge.aplication.usecases;

import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;

import java.util.List;

public interface PedidoUseCase {

    Pedido criarPedido(Pedido pedido);

    List<Pedido> findAll(String status);
}
