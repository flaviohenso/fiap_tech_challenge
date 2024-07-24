package com.techchallenge.techchallenge.core.requests.cliente;

public class CriarClienteDto {
    private final String nome;
    private final String cpf;
    private final String email;
    private final String telefone;

    public CriarClienteDto(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
