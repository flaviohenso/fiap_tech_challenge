package com.techchallenge.techchallenge.domain.entity;

import java.math.BigDecimal;
import java.util.UUID;

import com.techchallenge.techchallenge.domain.vo.Categoria;
import com.techchallenge.techchallenge.domain.vo.Id;
import lombok.Data;

@Data
public class Produto {
    private UUID id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private String imagem;
    private Categoria categoria;

}