package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComboEntity {
    ProdutoComboEntity lanche;
    ProdutoComboEntity acompanhamento;
    ProdutoComboEntity bebida;
    ProdutoComboEntity sobremesa;
}
