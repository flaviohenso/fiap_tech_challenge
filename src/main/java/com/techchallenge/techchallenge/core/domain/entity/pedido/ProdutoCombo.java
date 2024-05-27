package com.techchallenge.techchallenge.core.domain.entity.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoCombo {
    String idProduto;
    Integer quantity;
    Double price;
}
