package com.techchallenge.techchallenge.domain.entity;

import java.math.BigDecimal;

import com.techchallenge.techchallenge.domain.vo.Categoria;
import com.techchallenge.techchallenge.domain.vo.Id;

public class Produto {
    private Id id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private String imagem;
    private Categoria categoria;

}
