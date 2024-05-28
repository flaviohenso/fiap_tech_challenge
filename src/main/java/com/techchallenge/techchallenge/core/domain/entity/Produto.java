package com.techchallenge.techchallenge.core.domain.entity;

import java.math.BigDecimal;
import java.util.UUID;

import com.techchallenge.techchallenge.core.domain.vo.Categoria;

public class Produto {
    private UUID id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private String imagem;
    private Categoria categoria;

    public Produto() {
    }

    public Produto(Builder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.preco = builder.preco;
        this.descricao = builder.descricao;
        this.imagem = builder.imagem;
        this.categoria = builder.categoria;
    }

    public UUID getId() {
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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;

        Produto produto = (Produto) o;

        if (id != null ? !id.equals(produto.id) : produto.id != null) return false;
        if (nome != null ? !nome.equals(produto.nome) : produto.nome != null) return false;
        if (preco != null ? !preco.equals(produto.preco) : produto.preco != null) return false;
        if (descricao != null ? !descricao.equals(produto.descricao) : produto.descricao != null) return false;
        if (imagem != null ? !imagem.equals(produto.imagem) : produto.imagem != null) return false;
        return categoria == produto.categoria;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (imagem != null ? imagem.hashCode() : 0);
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        return result;
    }

    public static class Builder {
        private UUID id;
        private String nome;
        private BigDecimal preco;
        private String descricao;
        private String imagem;
        private Categoria categoria;

        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder withPreco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public Builder withDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder withImagem(String imagem) {
            this.imagem = imagem;
            return this;
        }

        public Builder withCategoria(Categoria categoria) {
            this.categoria = categoria;
            return this;
        }

        public Builder withIdRadom() {
            this.id = UUID.randomUUID();
            return this;
        }

        public Produto build() {
            return new Produto(this);
        }
    }
}
