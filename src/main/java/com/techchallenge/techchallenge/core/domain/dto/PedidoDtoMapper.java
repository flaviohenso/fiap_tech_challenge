package com.techchallenge.techchallenge.core.domain.dto;

import com.techchallenge.techchallenge.core.domain.dto.pedido.ComboRequestDto;
import com.techchallenge.techchallenge.core.domain.dto.pedido.CriarPedidoRequestDto;
import com.techchallenge.techchallenge.core.domain.dto.pedido.ProdutoComboRequestDto;
import com.techchallenge.techchallenge.core.domain.entity.pedido.Combo;
import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;
import com.techchallenge.techchallenge.core.domain.entity.pedido.ProdutoCombo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoDtoMapper {
    Pedido fromDto(CriarPedidoRequestDto criarPedidoRequestDto);

    CriarPedidoRequestDto toDto(Pedido pedido);

    Combo fromComboDto(ComboRequestDto comboRequestDto);

    ComboRequestDto toComboDto(Combo combo);

    ProdutoCombo fromComboProdutoDto(ProdutoComboRequestDto produtoComboRequestDto);

    ProdutoComboRequestDto toProdutoComboDto(ProdutoCombo produtocombo);
}
