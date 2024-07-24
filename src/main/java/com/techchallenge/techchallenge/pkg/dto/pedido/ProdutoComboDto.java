package com.techchallenge.techchallenge.pkg.dto.pedido;

import java.math.BigDecimal;

public class ProdutoComboDto {
    private final String idProduto;
    private final Integer quantity;
    private final BigDecimal price;

    public ProdutoComboDto(String idProduto, Integer quantity, BigDecimal price) {
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
