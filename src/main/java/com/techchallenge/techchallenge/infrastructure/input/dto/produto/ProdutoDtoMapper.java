package com.techchallenge.techchallenge.infrastructure.input.dto.produto;

import org.mapstruct.Mapper;

import com.techchallenge.techchallenge.core.domain.entity.Produto;

@Mapper(componentModel = "spring")
public interface ProdutoDtoMapper {
    Produto fromDto(ProdutoRequestDto produtoDto);
    ProdutoRequestDto toDto(Produto produto);
}