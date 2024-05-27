package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.produto;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.techchallenge.techchallenge.aplication.ports.output.ProdutoOutputPort;
import com.techchallenge.techchallenge.core.domain.entity.Produto;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.produto.repository.ProdutoRepository;

@Component
public class ProdutoMongoAdapter implements ProdutoOutputPort{
    
    private ProdutoRepository repository;

    public ProdutoMongoAdapter(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto create(Produto produto) {
        var created = repository.create(produto);
        return created;
    }

    @Override
    public List<Produto> getAll() {
        var produtos = repository.getAll();
        return produtos;
    }

    @Override
    public Produto updateProduto(Produto produto) {
        var updated = repository.updateProduto(produto);
        return updated;
    }

    @Override
    public Boolean deleteProduto(UUID id) {
        var deleted = repository.deleteProduto(id);
        return deleted;
    }  
}
