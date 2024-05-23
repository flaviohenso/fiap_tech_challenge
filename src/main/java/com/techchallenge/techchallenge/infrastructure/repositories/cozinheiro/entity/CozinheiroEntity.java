package com.techchallenge.techchallenge.infrastructure.repositories.cozinheiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cozinheiros")
public class CozinheiroEntity {
    @Id
    private UUID id;
    private String nome;
}
