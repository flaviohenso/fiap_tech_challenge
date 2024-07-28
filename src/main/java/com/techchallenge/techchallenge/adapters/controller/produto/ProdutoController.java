package com.techchallenge.techchallenge.adapters.controller.produto;

import com.techchallenge.techchallenge.adapters.gateway.produto.ProdutoGateway;
import com.techchallenge.techchallenge.core.entities.produto.Categoria;
import com.techchallenge.techchallenge.core.entities.produto.ProdutoEntity;
import com.techchallenge.techchallenge.core.requests.produto.AtualizarProdutoDto;
import com.techchallenge.techchallenge.core.requests.produto.CriarProdutoDto;
import com.techchallenge.techchallenge.core.usecases.ProdutoUseCaseImpl;
import com.techchallenge.techchallenge.pkg.interfaces.IProdutoDataSource;

import java.util.List;

public class ProdutoController {
    private final IProdutoDataSource dataSource;

    public ProdutoController(IProdutoDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ProdutoEntity cadastrarProduto(CriarProdutoDto criarProdutoDto) {
        ProdutoGateway produtoGateway = new ProdutoGateway(dataSource);
        ProdutoUseCaseImpl produtoUseCase = new ProdutoUseCaseImpl(produtoGateway);

        return produtoUseCase.cadastrar(criarProdutoDto);
    }

    public List<ProdutoEntity> buscarTodos(Categoria categoria) {
        ProdutoGateway produtoGateway = new ProdutoGateway(dataSource);
        ProdutoUseCaseImpl produtoUseCase = new ProdutoUseCaseImpl(produtoGateway);

        return produtoUseCase.buscarTodos(categoria);
    }

    public void deletar(String id) {
        ProdutoGateway produtoGateway = new ProdutoGateway(dataSource);
        ProdutoUseCaseImpl produtoUseCase = new ProdutoUseCaseImpl(produtoGateway);

        produtoUseCase.deletar(id);
    }

    public ProdutoEntity buscarPorId(String id) {
        ProdutoGateway produtoGateway = new ProdutoGateway(dataSource);
        ProdutoUseCaseImpl produtoUseCase = new ProdutoUseCaseImpl(produtoGateway);

        return produtoUseCase.buscarPorId(id);
    }

    public ProdutoEntity atualizar(String id, AtualizarProdutoDto dto) {
        ProdutoGateway produtoGateway = new ProdutoGateway(dataSource);
        ProdutoUseCaseImpl produtoUseCase = new ProdutoUseCaseImpl(produtoGateway);

        return produtoUseCase.atualizar(id, dto);
    }
}
