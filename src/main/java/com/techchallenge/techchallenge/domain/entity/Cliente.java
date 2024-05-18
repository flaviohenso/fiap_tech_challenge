package com.techchallenge.techchallenge.domain.entity;

import java.util.UUID;

import lombok.Data;

@Data
public class Cliente {

    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;  
}