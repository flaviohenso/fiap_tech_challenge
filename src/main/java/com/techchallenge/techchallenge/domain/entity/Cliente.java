package com.techchallenge.techchallenge.domain.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Cliente {

    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
}
