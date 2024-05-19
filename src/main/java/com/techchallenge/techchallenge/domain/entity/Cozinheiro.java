package com.techchallenge.techchallenge.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cozinheiro {
    private UUID id;
    private String nome;
}
