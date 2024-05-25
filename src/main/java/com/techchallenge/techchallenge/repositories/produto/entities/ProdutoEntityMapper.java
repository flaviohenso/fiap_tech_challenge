package com.techchallenge.techchallenge.repositories.produto.entities;


import com.techchallenge.techchallenge.domain.entity.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {

    ProdutoEntity toEntity(Produto produto);

    Produto fromEntity(ProdutoEntity produtoEntityEntity);


}
