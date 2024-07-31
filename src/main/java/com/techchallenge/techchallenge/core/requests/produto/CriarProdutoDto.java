package com.techchallenge.techchallenge.core.requests.produto;

import com.techchallenge.techchallenge.core.entities.produto.Categoria;

import java.math.BigDecimal;

public class CriarProdutoDto {
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private String imagem;
    private Categoria categoria;

    public CriarProdutoDto(String nome, BigDecimal preco, String descricao, String imagem, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }
}
