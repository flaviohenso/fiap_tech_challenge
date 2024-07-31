package com.techchallenge.techchallenge.core.usecases;

import com.techchallenge.techchallenge.adapters.gateway.produto.ProdutoGateway;
import com.techchallenge.techchallenge.core.entities.produto.Categoria;
import com.techchallenge.techchallenge.core.entities.produto.ProdutoEntity;
import com.techchallenge.techchallenge.core.exceptions.ProdutoNotFoundException;
import com.techchallenge.techchallenge.core.requests.produto.AtualizarProdutoDto;
import com.techchallenge.techchallenge.core.requests.produto.CriarProdutoDto;

import java.time.OffsetDateTime;
import java.util.List;

public class ProdutoUseCaseImpl {

    private final ProdutoGateway produtoGateway;

    public ProdutoUseCaseImpl(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public ProdutoEntity cadastrar(CriarProdutoDto criarProdutoDto) {
        var produto = toProdutoEntity(criarProdutoDto);

        return produtoGateway.criar(produto);
    }

    private ProdutoEntity toProdutoEntity(CriarProdutoDto dto) {
        OffsetDateTime now = OffsetDateTime.now();
        return new ProdutoEntity(
                null,
                dto.getNome(),
                dto.getPreco(),
                dto.getDescricao(),
                dto.getImagem(),
                dto.getCategoria(),
                now,
                now
        );
    }

    public ProdutoEntity buscarPorId(String id) {
        return produtoGateway.getById(id);
    }

    public List<ProdutoEntity> buscarTodos(Categoria categoria) {
        return produtoGateway.findAll(categoria);
    }

    public ProdutoEntity atualizar(String id, AtualizarProdutoDto dto) {
        ProdutoEntity produto = produtoGateway.getById(id);
        if (produto == null)
            throw new ProdutoNotFoundException(id);

        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setImagem(dto.getImagem());
        produto.setUpdatedAt(OffsetDateTime.now());
        return produtoGateway.atualizar(produto);
    }

    public void deletar(String id) {
        produtoGateway.deleteById(id);
    }
}
