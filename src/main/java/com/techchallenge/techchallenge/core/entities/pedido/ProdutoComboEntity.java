package com.techchallenge.techchallenge.core.entities.pedido;

import com.techchallenge.techchallenge.core.exceptions.InvalidProdutoComboException;

import java.math.BigDecimal;
import java.util.Objects;

public class ProdutoComboEntity {
    private final String idProduto;
    private final Integer quantity;
    private final BigDecimal price;

    public ProdutoComboEntity(String idProduto, Integer quantity, BigDecimal price) {

        validate(idProduto, quantity, price);
        this.idProduto = idProduto;
        this.quantity = quantity;
        this.price = price;
    }

    private void validate(String idProduto, Integer quantity, BigDecimal price) {
        if (idProduto == null || idProduto.isBlank())
            throw new InvalidProdutoComboException("produto precisa ser informado");

        if (quantity == null || quantity <= 0)
            throw new InvalidProdutoComboException("produto precisa ter uma quantidade maior que zero");

        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidProdutoComboException("Preço do produto precisa ser maior que zero");
    }

    public String getIdProduto() {
        return idProduto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotalPrice() {
        return getPrice().multiply(BigDecimal.valueOf(getQuantity()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoComboEntity that = (ProdutoComboEntity) o;
        return Objects.equals(getIdProduto(), that.getIdProduto()) && Objects.equals(getQuantity(), that.getQuantity()) && Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProduto(), getQuantity(), getPrice());
    }

    @Override
    public String toString() {
        return "ProdutoComboEntity{" +
                "idProduto='" + idProduto + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
