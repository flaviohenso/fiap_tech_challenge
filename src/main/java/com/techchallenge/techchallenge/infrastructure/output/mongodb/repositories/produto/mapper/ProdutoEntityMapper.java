package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.produto.mapper;



import org.mapstruct.Mapper;

import com.techchallenge.techchallenge.core.domain.entity.Produto;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.produto.entity.ProdutoEntity;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {
    ProdutoEntity toEntity(Produto produto);
    Produto fromEntity(ProdutoEntity entity);
}
