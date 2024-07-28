package com.techchallenge.techchallenge.pkg.interfaces;

import com.techchallenge.techchallenge.core.entities.produto.Categoria;
import com.techchallenge.techchallenge.pkg.dto.produto.ProdutoDto;

import java.util.List;

public interface IProdutoDataSource {
    ProdutoDto insertProduto(ProdutoDto produto);

    ProdutoDto updateProduto(ProdutoDto produto);

    void deleteById(String id);

    ProdutoDto getProdutoById(String id);

    List<ProdutoDto> findAll(Categoria categoria);
}
