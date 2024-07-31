package com.techchallenge.techchallenge.adapters.gateway.produto;

import com.techchallenge.techchallenge.adapters.gateway.produto.mapper.ProdutoMapper;
import com.techchallenge.techchallenge.core.entities.produto.Categoria;
import com.techchallenge.techchallenge.core.entities.produto.ProdutoEntity;
import com.techchallenge.techchallenge.core.exceptions.InvalidProdutoException;
import com.techchallenge.techchallenge.pkg.dto.produto.ProdutoDto;
import com.techchallenge.techchallenge.pkg.interfaces.IProdutoDataSource;

import java.util.List;
import java.util.Optional;

public class ProdutoGateway {

    private final IProdutoDataSource dataSource;

    public ProdutoGateway(IProdutoDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ProdutoEntity criar(ProdutoEntity produto) {
        if (produto.getId() != null) throw new InvalidProdutoException("Produto já existente");
        ProdutoDto savedProduto = dataSource.insertProduto(ProdutoMapper.toProdutoDto(produto));
        return ProdutoMapper.toProdutoEntity(savedProduto);
    }

    public ProdutoEntity atualizar(ProdutoEntity produto) {
        if (produto.getId() == null) throw new InvalidProdutoException("Produto não existente");
        ProdutoDto produtoDto = dataSource.updateProduto(ProdutoMapper.toProdutoDto(produto));
        return ProdutoMapper.toProdutoEntity(produtoDto);
    }

    public ProdutoEntity getById(String id) {
        return Optional.of(id)
                .map(dataSource::getProdutoById)
                .map(ProdutoMapper::toProdutoEntity)
                .orElse(null);
    }

    public List<ProdutoEntity> findAll(Categoria categoria) {
        return dataSource.findAll(categoria).stream().map(ProdutoMapper::toProdutoEntity).toList();
    }

    public void deleteById(String id) {
        dataSource.deleteById(id);
    }
}
