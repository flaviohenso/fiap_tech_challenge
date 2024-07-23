package com.techchallenge.techchallenge.adapters.gateway;

import com.techchallenge.techchallenge.adapters.gateway.mapper.PedidoMapper;
import com.techchallenge.techchallenge.core.entities.pedido.PedidoEntity;
import com.techchallenge.techchallenge.core.exceptions.InvalidPedidoException;
import com.techchallenge.techchallenge.pkg.dto.PedidoDto;
import com.techchallenge.techchallenge.pkg.interfaces.IPedidoDataSource;

import java.util.List;
import java.util.Optional;

public class PedidoGateway {

    private final IPedidoDataSource dataSource;

    public PedidoGateway(IPedidoDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public PedidoEntity criar(PedidoEntity pedido) {
        if (pedido.getId() != null) throw new InvalidPedidoException("Pedido já existente");
        PedidoDto savedPedido = dataSource.insertPedido(PedidoMapper.toPedidoDto(pedido));
        return PedidoMapper.toPedidoEntity(savedPedido);
    }

    public PedidoEntity atualizar(PedidoEntity pedido) {
        if (pedido.getId() == null) throw new InvalidPedidoException("Pedido não existente");
        PedidoDto savedPedido = dataSource.savePedido(PedidoMapper.toPedidoDto(pedido));
        return PedidoMapper.toPedidoEntity(savedPedido);
    }

    public PedidoEntity getById(String id) {
        return Optional.of(id)
                .map(dataSource::getPedidoById)
                .map(PedidoMapper::toPedidoEntity)
                .orElse(null);
    }

    public List<PedidoEntity> findAll() {
        return dataSource.findAll().stream().map(PedidoMapper::toPedidoEntity).toList();
    }
}
