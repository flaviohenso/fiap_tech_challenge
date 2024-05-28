package com.techchallenge.techchallenge.infrastructure.input.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoComboRequestDto {
    String idProduto;
    Integer quantity;
    BigDecimal price;
}
