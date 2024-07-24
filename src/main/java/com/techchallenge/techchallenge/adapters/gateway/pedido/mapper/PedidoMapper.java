package com.techchallenge.techchallenge.adapters.gateway.pedido.mapper;

import com.techchallenge.techchallenge.core.entities.pedido.ComboEntity;
import com.techchallenge.techchallenge.core.entities.pedido.PedidoEntity;
import com.techchallenge.techchallenge.core.entities.pedido.ProdutoComboEntity;
import com.techchallenge.techchallenge.pkg.dto.pedido.ComboDto;
import com.techchallenge.techchallenge.pkg.dto.pedido.PedidoDto;
import com.techchallenge.techchallenge.pkg.dto.pedido.ProdutoComboDto;

public class PedidoMapper {

    public static PedidoDto toPedidoDto(PedidoEntity pedido) {
        return new PedidoDto(
                pedido.getId(),
                pedido.getStatus(),
                pedido.getClientId(),
                pedido.getCombos().stream().map(PedidoMapper::toComboDto).toList(),
                pedido.getCreatedAt(),
                pedido.getUpdatedAt()
        );
    }

    public static PedidoEntity toPedidoEntity(PedidoDto pedido) {
        return new PedidoEntity(
                pedido.getId(),
                pedido.getStatus(),
                pedido.getClientId(),
                pedido.getCombos().stream().map(PedidoMapper::toComboEntity).toList(),
                pedido.getCreatedAt(),
                pedido.getUpdatedAt()
        );
    }

    static ComboDto toComboDto(ComboEntity comboEntity) {
        return new ComboDto(
                toProdutoComboDto(comboEntity.getLanche()),
                toProdutoComboDto(comboEntity.getAcompanhamento()),
                toProdutoComboDto(comboEntity.getBebida()),
                toProdutoComboDto(comboEntity.getSobremesa())
        );
    }

    static ComboEntity toComboEntity(ComboDto comboDto) {
        return new ComboEntity(
                toProdutoComboEntity(comboDto.getLanche()),
                toProdutoComboEntity(comboDto.getAcompanhamento()),
                toProdutoComboEntity(comboDto.getBebida()),
                toProdutoComboEntity(comboDto.getSobremesa())
        );
    }

    static ProdutoComboDto toProdutoComboDto(ProdutoComboEntity produtoComboEntity) {
        return new ProdutoComboDto(
                produtoComboEntity.getIdProduto(),
                produtoComboEntity.getQuantity(),
                produtoComboEntity.getPrice()
        );
    }

    static ProdutoComboEntity toProdutoComboEntity(ProdutoComboDto produtoComboDto) {
        return new ProdutoComboEntity(
                produtoComboDto.getIdProduto(),
                produtoComboDto.getQuantity(),
                produtoComboDto.getPrice()
        );
    }
}
