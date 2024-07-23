package com.techchallenge.techchallenge.aplication.ports.input;

import com.techchallenge.techchallenge.aplication.ports.output.ProdutoOutputPort;
import com.techchallenge.techchallenge.core.entities.Produto;
import com.techchallenge.techchallenge.core.usecases.ProdutoUseCase;
import com.techchallenge.techchallenge.infrastructure.input.dto.produto.ProdutoRequestDto;

import java.util.List;
import java.util.UUID;

public class ProdutoInputPort implements ProdutoUseCase {

    private ProdutoOutputPort produtoOutputPort;

    public ProdutoInputPort(ProdutoOutputPort produtoOutputPort) {
        this.produtoOutputPort = produtoOutputPort;
    }

    @Override
    public Produto createProduto(Produto produto) {
        return produtoOutputPort.create(produto);
    }

    @Override
    public Produto updateProduto(Produto produto) {
        return produtoOutputPort.updateProduto(produto);
    }

    @Override
    public Boolean deleteProduto(UUID id) {
        return produtoOutputPort.deleteProduto(id);
    }

    @Override
    public List<Produto> listProdutos() {
        return produtoOutputPort.getAll();
    }

    @Override
    public void getProduto(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProduto'");
    }

    @Override
    public Produto mapperDtoToProduto(ProdutoRequestDto produtoRequestDto) {
        return new Produto.Builder()
                .withNome(produtoRequestDto.getNome())
                .withDescricao(produtoRequestDto.getDescricao())
                .withPreco(produtoRequestDto.getPreco())
                .withCategoria(produtoRequestDto.getCategoria())
                .withImagem(produtoRequestDto.getImagem())
                .withIdRadom()
                .build();
    }

}
