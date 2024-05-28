package com.techchallenge.techchallenge.core.domain.entity.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
public class Combo {
    private ProdutoCombo lanche;
    private ProdutoCombo acompanhamento;
    private ProdutoCombo bebida;
    private ProdutoCombo sobremesa;

    public BigDecimal getTotalPrice() {
        return Stream.of(getLanche(), getBebida(), getAcompanhamento(), getSobremesa())
                .filter(Objects::nonNull)
                .map(ProdutoCombo::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
