package com.techchallenge.techchallenge.core.domain.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoComboRequestDto {
    String idProduto;
    Integer quantity;
    Double price;
}
