package com.techchallenge.techchallenge.core.domain.dto;

import org.mapstruct.Mapper;

import com.techchallenge.techchallenge.core.domain.entity.Produto;

@Mapper(componentModel = "spring")
public interface ProdutoDtoMapper {
    Produto fromDto(ProdutoRequestDto produtoDto);
    ProdutoRequestDto toDto(Produto produto);
}