package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.produto.mapper;


import com.techchallenge.techchallenge.core.entities.Produto;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.produto.entity.ProdutoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {
    ProdutoEntity toEntity(Produto produto);

    Produto fromEntity(ProdutoEntity entity);
}
