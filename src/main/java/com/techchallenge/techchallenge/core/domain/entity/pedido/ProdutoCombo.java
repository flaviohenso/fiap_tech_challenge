package com.techchallenge.techchallenge.core.domain.entity.pedido;

import java.math.BigDecimal;
import java.util.Objects;

public class ProdutoCombo {
    private String idProduto;
    private Integer quantity;
    private BigDecimal price;

    public ProdutoCombo() {
    }

    public ProdutoCombo(String idProduto, Integer quantity, BigDecimal price) {
        this.idProduto = idProduto;
        this.quantity = quantity;
        this.price = price;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return getPrice().multiply(BigDecimal.valueOf(getQuantity()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoCombo that = (ProdutoCombo) o;
        return Objects.equals(getIdProduto(), that.getIdProduto()) && Objects.equals(getQuantity(), that.getQuantity()) && Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProduto(), getQuantity(), getPrice());
    }

    @Override
    public String toString() {
        return "ProdutoCombo{" +
                "idProduto='" + idProduto + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
