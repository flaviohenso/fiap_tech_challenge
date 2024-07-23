package com.techchallenge.techchallenge.core.usecases;

import com.techchallenge.techchallenge.core.entities.Produto;
import com.techchallenge.techchallenge.infrastructure.input.dto.produto.ProdutoRequestDto;

import java.util.List;
import java.util.UUID;

public interface ProdutoUseCase {
    Produto createProduto(Produto produto);

    Produto updateProduto(Produto produto);

    Boolean deleteProduto(UUID id);

    List<Produto> listProdutos();

    void getProduto(String id);

    Produto mapperDtoToProduto(ProdutoRequestDto produtoRequestDto);
}
