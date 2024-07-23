package com.techchallenge.techchallenge.core.requests;

public class CriarComboDto {
    private final CriarProdutoComboDto lanche;
    private final CriarProdutoComboDto acompanhamento;
    private final CriarProdutoComboDto bebida;
    private final CriarProdutoComboDto sobremesa;

    public CriarComboDto(
            CriarProdutoComboDto lanche,
            CriarProdutoComboDto acompanhamento,
            CriarProdutoComboDto bebida,
            CriarProdutoComboDto sobremesa
    ) {
        this.lanche = lanche;
        this.acompanhamento = acompanhamento;
        this.bebida = bebida;
        this.sobremesa = sobremesa;
    }

    public CriarProdutoComboDto getLanche() {
        return lanche;
    }

    public CriarProdutoComboDto getAcompanhamento() {
        return acompanhamento;
    }

    public CriarProdutoComboDto getBebida() {
        return bebida;
    }

    public CriarProdutoComboDto getSobremesa() {
        return sobremesa;
    }
}
