package com.techchallenge.techchallenge.infrastructure.repositories.cliente.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

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
