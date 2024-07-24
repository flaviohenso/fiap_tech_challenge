package com.techchallenge.techchallenge.infrastructure.input.dto.produto;

import com.techchallenge.techchallenge.core.entities.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoDtoMapper {
    Produto fromDto(ProdutoRequestDto produtoDto);

    ProdutoRequestDto toDto(Produto produto);
}