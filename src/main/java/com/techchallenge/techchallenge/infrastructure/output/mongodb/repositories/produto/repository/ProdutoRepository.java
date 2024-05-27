package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.produto.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.techchallenge.techchallenge.core.domain.entity.Produto;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.produto.mapper.ProdutoEntityMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProdutoRepository implements IProdutoRepository {

    private final ProdutoEntityMapper mapper;
    private final MongoProdutoRepository repository;

    @Override
    public List<Produto> getAll() {
        return repository.findAll().stream().map(mapper::fromEntity).toList();
    }

    @Override
    public Produto create(Produto produto) {
        return Optional.of(produto)
                .map(mapper::toEntity)
                .map(repository::save)
                .map(mapper::fromEntity)
                .orElse(null);
    }

    public Produto updateProduto(Produto produto) {
        return Optional.of(produto)
                .map(mapper::toEntity)
                .map(repository::save)
                .map(mapper::fromEntity)
                .orElse(null);
    }
    
    public Boolean deleteProduto(UUID id) {
        repository.deleteById(id);
        return true;
    }
}
