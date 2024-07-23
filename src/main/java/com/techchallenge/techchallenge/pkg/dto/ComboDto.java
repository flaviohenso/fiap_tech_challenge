package com.techchallenge.techchallenge.pkg.dto;

public class ComboDto {
    private final ProdutoComboDto lanche;
    private final ProdutoComboDto acompanhamento;
    private final ProdutoComboDto bebida;
    private final ProdutoComboDto sobremesa;

    public ComboDto(
            ProdutoComboDto lanche,
            ProdutoComboDto acompanhamento,
            ProdutoComboDto bebida,
            ProdutoComboDto sobremesa
    ) {
        this.lanche = lanche;
        this.acompanhamento = acompanhamento;
        this.bebida = bebida;
        this.sobremesa = sobremesa;
    }

    public ProdutoComboDto getLanche() {
        return lanche;
    }

    public ProdutoComboDto getAcompanhamento() {
        return acompanhamento;
    }

    public ProdutoComboDto getBebida() {
        return bebida;
    }

    public ProdutoComboDto getSobremesa() {
        return sobremesa;
    }
}
