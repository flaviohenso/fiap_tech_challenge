package com.techchallenge.techchallenge.repositories.produto;

import com.techchallenge.techchallenge.domain.entity.Produto;
import com.techchallenge.techchallenge.repositories.produto.entities.ProdutoEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ProdutoRepository implements IProdutoRepository{

    private final ProdutoEntityMapper mapper;

    private final MongoProdutoRepository repository;

    @Override
    public List<Produto> getAll() {
        return repository.findAll().stream().map(mapper::fromEntity).toList();
    }

    @Override
    public Optional<Produto> getById(UUID id) {
        return repository.findById(id).map(mapper::fromEntity);
    }

    @Override
    public Produto save(Produto produto) {
        return Optional.of(produto)
                .map(mapper::toEntity)
                .map(repository::save)
                .map(mapper::fromEntity)
                .orElse(null);
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }

}



