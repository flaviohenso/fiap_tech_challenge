package com.techchallenge.techchallenge.repositories.produto.entities;


import com.techchallenge.techchallenge.domain.vo.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "produtos")
public class ProdutoEntity {
    @Id
    private UUID id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private String imagem;
    private Categoria categoria;
}
