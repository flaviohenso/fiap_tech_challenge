package com.techchallenge.techchallenge.usecases;
import com.techchallenge.techchallenge.domain.entity.Produto;
import com.techchallenge.techchallenge.exceptions.NotFoundException;
import com.techchallenge.techchallenge.repositories.produto.IProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class ProdutoUseCases {
    final private IProdutoRepository repository;


    public List<Produto> findAll() {
        return repository.getAll();
    }


    public Produto findById(UUID id) {
        return repository.getById(id).orElseThrow(() -> new NotFoundException("produto not found"));
    }

    public Produto create(Produto produto) {
        produto.setId(UUID.randomUUID());
        return repository.save(produto);
    }

    public Produto update(Produto produto) {
        repository.getById (produto.getId())
                .orElseThrow(() -> new NotFoundException("produto not found"));
        return repository.save(produto);
    }

    public void delete(UUID id) {
        repository.delete(id);
    }

}