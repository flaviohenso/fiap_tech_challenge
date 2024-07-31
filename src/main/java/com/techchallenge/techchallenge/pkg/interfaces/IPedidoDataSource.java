package com.techchallenge.techchallenge.pkg.interfaces;

import com.techchallenge.techchallenge.core.entities.pedido.PedidoStatus;
import com.techchallenge.techchallenge.pkg.dto.pedido.PedidoDto;

import java.util.List;

public interface IPedidoDataSource {
    PedidoDto insertPedido(PedidoDto pedido);

    PedidoDto savePedido(PedidoDto pedido);

    PedidoDto getPedidoById(String id);

    List<PedidoDto> findAllInStatus(List<PedidoStatus> statuses);

    List<PedidoDto> findAll();
}
