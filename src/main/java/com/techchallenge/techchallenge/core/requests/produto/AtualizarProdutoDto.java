package com.techchallenge.techchallenge.core.requests.produto;

import java.math.BigDecimal;

public class AtualizarProdutoDto {
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private String imagem;

    public AtualizarProdutoDto(String nome, BigDecimal preco, String descricao, String imagem) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImagem() {
        return imagem;
    }
}
