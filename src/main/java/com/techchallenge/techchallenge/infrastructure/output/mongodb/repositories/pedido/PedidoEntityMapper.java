package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido;


import com.techchallenge.techchallenge.core.domain.entity.pedido.Combo;
import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;
import com.techchallenge.techchallenge.core.domain.entity.pedido.ProdutoCombo;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.entities.ComboEntity;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.entities.PedidoEntity;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.entities.ProdutoComboEntity;
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
