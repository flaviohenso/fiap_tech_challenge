package com.techchallenge.techchallenge.controllers.produto.dto;


import com.techchallenge.techchallenge.domain.vo.Categoria;
import com.techchallenge.techchallenge.domain.vo.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertProdutoRequestDto {
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private String imagem;
    private Categoria categoria;
}
