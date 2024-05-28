package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoComboEntity {
    String idProduto;
    Integer quantity;
    BigDecimal price;
}
