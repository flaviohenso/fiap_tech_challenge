package com.techchallenge.techchallenge.aplication.controllers.cliente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertClienteRequestDto {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
}
