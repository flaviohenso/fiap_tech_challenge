package com.techchallenge.techchallenge.core.entities.pedido;

import com.techchallenge.techchallenge.core.exceptions.InvalidComboException;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.stream.Stream;

public class ComboEntity {
    private final ProdutoComboEntity lanche;
    private final ProdutoComboEntity acompanhamento;
    private final ProdutoComboEntity bebida;
    private final ProdutoComboEntity sobremesa;

    public ComboEntity(
            ProdutoComboEntity lanche,
            ProdutoComboEntity acompanhamento,
            ProdutoComboEntity bebida,
            ProdutoComboEntity sobremesa
    ) {
        validate(lanche, acompanhamento, bebida, sobremesa);

        this.lanche = lanche;
        this.acompanhamento = acompanhamento;
        this.bebida = bebida;
        this.sobremesa = sobremesa;
    }

    private void validate(ProdutoComboEntity lanche, ProdutoComboEntity acompanhamento, ProdutoComboEntity bebida, ProdutoComboEntity sobremesa) {
        if (lanche == null && acompanhamento == null && bebida == null && sobremesa == null) {
            throw new InvalidComboException("Combo precisa ter pelo menos um produto");
        }
    }

    public ProdutoComboEntity getLanche() {
        return lanche;
    }

    public ProdutoComboEntity getAcompanhamento() {
        return acompanhamento;
    }

    public ProdutoComboEntity getBebida() {
        return bebida;
    }

    public ProdutoComboEntity getSobremesa() {
        return sobremesa;
    }

    public BigDecimal getTotalPrice() {
        return Stream.of(getLanche(), getBebida(), getAcompanhamento(), getSobremesa())
                .filter(Objects::nonNull)
                .map(ProdutoComboEntity::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComboEntity that = (ComboEntity) o;
        return Objects.equals(getLanche(), that.getLanche()) && Objects.equals(getAcompanhamento(), that.getAcompanhamento()) && Objects.equals(getBebida(), that.getBebida()) && Objects.equals(getSobremesa(), that.getSobremesa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLanche(), getAcompanhamento(), getBebida(), getSobremesa());
    }
}
