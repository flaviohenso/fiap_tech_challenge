package com.techchallenge.techchallenge.aplication.usecases;

import java.util.List;
import java.util.UUID;

import com.techchallenge.techchallenge.core.domain.entity.Produto;
import com.techchallenge.techchallenge.infrastructure.input.dto.produto.ProdutoRequestDto;

public interface ProdutoUseCase {
    Produto createProduto(Produto produto);
    Produto updateProduto(Produto produto);
    Boolean deleteProduto(UUID id);
    List<Produto> listProdutos();
    void getProduto(String id);
    Produto mapperDtoToProduto(ProdutoRequestDto produtoRequestDto);
}
