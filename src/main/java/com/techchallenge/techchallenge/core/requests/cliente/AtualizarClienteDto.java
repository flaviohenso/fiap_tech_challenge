package com.techchallenge.techchallenge.core.requests.cliente;

public class AtualizarClienteDto {
    private final String email;
    private final String telefone;

    public AtualizarClienteDto(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
