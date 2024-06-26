package com.techchallenge.techchallenge.infrastructure.input.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComboRequestDto {
    ProdutoComboRequestDto lanche;
    ProdutoComboRequestDto acompanhamento;
    ProdutoComboRequestDto bebida;
    ProdutoComboRequestDto sobremesa;
}
