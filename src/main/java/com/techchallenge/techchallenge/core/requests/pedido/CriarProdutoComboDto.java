package com.techchallenge.techchallenge.core.requests.pedido;

import java.math.BigDecimal;

public class CriarProdutoComboDto {
    private final String idProduto;
    private final Integer quantity;
    private final BigDecimal price;

    public CriarProdutoComboDto(String idProduto, Integer quantity, BigDecimal price) {
        this.idProduto = idProduto;
        this.quantity = quantity;
        this.price = price;
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
}
