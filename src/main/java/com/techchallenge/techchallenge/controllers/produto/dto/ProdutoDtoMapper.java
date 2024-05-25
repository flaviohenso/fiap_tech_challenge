package com.techchallenge.techchallenge.controllers.produto.dto;

import com.techchallenge.techchallenge.domain.entity.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoDtoMapper {
    Produto fromDto(UpsertProdutoRequestDto produtoDto);

    UpsertProdutoRequestDto toDto(Produto produto);
}
