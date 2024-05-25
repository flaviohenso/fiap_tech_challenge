package com.techchallenge.techchallenge.repositories.produto;

import com.techchallenge.techchallenge.domain.entity.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProdutoRepository {

    List<Produto> getAll();

    Optional<Produto> getById(UUID id);

    Produto save(Produto produto);

    void delete(UUID uuid);
}
