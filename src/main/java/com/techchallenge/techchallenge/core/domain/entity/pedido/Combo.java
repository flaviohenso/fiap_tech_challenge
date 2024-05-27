package com.techchallenge.techchallenge.core.domain.entity.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Combo {
    ProdutoCombo lanche;
    ProdutoCombo acompanhamento;
    ProdutoCombo bebida;
    ProdutoCombo sobremesa;
}
