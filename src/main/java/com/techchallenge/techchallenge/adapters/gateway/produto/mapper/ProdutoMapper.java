package com.techchallenge.techchallenge.adapters.gateway.produto.mapper;

import com.techchallenge.techchallenge.core.entities.produto.ProdutoEntity;
import com.techchallenge.techchallenge.pkg.dto.produto.ProdutoDto;

public class ProdutoMapper {

    public static ProdutoDto toProdutoDto(ProdutoEntity produto) {
        return new ProdutoDto(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getDescricao(),
                produto.getImagem(),
                produto.getCategoria(),
                produto.getCreatedAt(),
                produto.getUpdatedAt()
        );
    }

    public static ProdutoEntity toProdutoEntity(ProdutoDto produto) {
        return new ProdutoEntity(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getDescricao(),
                produto.getImagem(),
                produto.getCategoria(),
                produto.getCreatedAt(),
                produto.getUpdatedAt()
        );
    }
}
