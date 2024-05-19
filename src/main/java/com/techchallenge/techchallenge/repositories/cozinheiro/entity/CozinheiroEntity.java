package com.techchallenge.techchallenge.repositories.cozinheiro.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cozinheiros")
public class CozinheiroEntity {
    @Id
    private UUID id;
    private String nome;

}
