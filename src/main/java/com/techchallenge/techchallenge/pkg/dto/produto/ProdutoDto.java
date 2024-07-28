package com.techchallenge.techchallenge.pkg.dto.produto;

import com.techchallenge.techchallenge.core.entities.produto.Categoria;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class ProdutoDto {
    private String id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private String imagem;
    private Categoria categoria;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public ProdutoDto(
            String id,
            String nome,
            BigDecimal preco,
            String descricao,
            String imagem,
            Categoria categoria,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt
    ) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
        this.categoria = categoria;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(String id) {
        this.id = id;
    }
}
