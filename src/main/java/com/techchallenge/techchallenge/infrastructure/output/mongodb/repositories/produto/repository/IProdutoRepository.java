package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.produto.repository;

import java.util.List;
import java.util.UUID;

import com.techchallenge.techchallenge.core.domain.entity.Produto;

public interface IProdutoRepository {
    List<Produto> getAll();
    Produto create(Produto produto);
    public Produto updateProduto(Produto produto);
    public Boolean deleteProduto(UUID id);
}
