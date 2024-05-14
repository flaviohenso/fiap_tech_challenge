package com.techchallenge.techchallenge.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@Document(collection = "cozinheiros")
public class Cozinheiro {
    @Id
    private UUID id;
    private String nome;
}
