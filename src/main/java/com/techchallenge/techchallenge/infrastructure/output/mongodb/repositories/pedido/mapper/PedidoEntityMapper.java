package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.mapper;


import com.techchallenge.techchallenge.core.domain.entity.pedido.Combo;
import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;
import com.techchallenge.techchallenge.core.domain.entity.pedido.ProdutoCombo;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.entity.ComboEntity;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.entity.PedidoEntity;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.entity.ProdutoComboEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoEntityMapper {

    PedidoEntity toEntity(Pedido pedido);

    Pedido fromEntity(PedidoEntity pedidoEntity);

    ComboEntity toComboEntity(Combo pedido);

    Combo fromComboEntity(ComboEntity comboEntity);

    ProdutoComboEntity toProdutoComboEntity(ProdutoCombo produtoCombo);

    ProdutoCombo fromProdutoComboEntity(ProdutoComboEntity produtoComboEntity);
}
