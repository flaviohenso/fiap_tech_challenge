package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clientes")
public class ClienteEntity {
    @Id
    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
}
