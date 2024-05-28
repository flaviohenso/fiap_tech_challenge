package com.techchallenge.techchallenge.infrastructure.input.dto.produto;

import java.math.BigDecimal;

import com.techchallenge.techchallenge.core.domain.vo.Categoria;

public class ProdutoRequestDto {

    
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private String imagem;
    private Categoria categoria;

    public ProdutoRequestDto() {
    }

    public ProdutoRequestDto(String nome, BigDecimal preco, String descricao, String imagem, Categoria categoria) {
        
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ProdutoRequestDto)) return false;
        final ProdutoRequestDto other = (ProdutoRequestDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$nome = this.getNome();
        final Object other$nome = other.getNome();
        if (this$nome == null ? other$nome != null : !this$nome.equals(other$nome)) return false;
        final Object this$preco = this.getPreco();
        final Object other$preco = other.getPreco();
        if (this$preco == null ? other$preco != null : !this$preco.equals(other$preco)) return false;
        final Object this$descricao = this.getDescricao();
        final Object other$descricao = other.getDescricao();
        if (this$descricao == null ? other$descricao != null : !this$descricao.equals(other$descricao)) return false;
        final Object this$imagem = this.getImagem();
        final Object other$imagem = other.getImagem();
        if (this$imagem == null ? other$imagem != null : !this$imagem.equals(other$imagem)) return false;
        final Object this$categoria = this.getCategoria();
        final Object other$categoria = other.getCategoria();
        if (this$categoria == null ? other$categoria != null : !this$categoria.equals(other$categoria)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ProdutoRequestDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $nome = this.getNome();
        result = result * PRIME + ($nome == null ? 43 : $nome.hashCode());
        final Object $preco = this.getPreco();
        result = result * PRIME + ($preco == null ? 43 : $preco.hashCode());
        final Object $descricao = this.getDescricao();
        result = result * PRIME + ($descricao == null ? 43 : $descricao.hashCode());
        final Object $imagem = this.getImagem();
        result = result * PRIME + ($imagem == null ? 43 : $imagem.hashCode());
        final Object $categoria = this.getCategoria();
        result = result * PRIME + ($categoria == null ? 43 : $categoria.hashCode());
        return result;
    }
}
