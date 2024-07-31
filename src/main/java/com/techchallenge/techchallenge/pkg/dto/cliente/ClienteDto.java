package com.techchallenge.techchallenge.pkg.dto.cliente;

import java.time.OffsetDateTime;
import java.util.Objects;

public class ClienteDto {
    private String id;
    private final String nome;
    private final String cpf;
    private final String email;
    private final String telefone;
    private final OffsetDateTime createdAt;
    private final OffsetDateTime updatedAt;

    public ClienteDto(
            String id,
            String nome,
            String cpf,
            String email,
            String telefone,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt
    ) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDto that = (ClienteDto) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getCpf(), that.getCpf()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getTelefone(), that.getTelefone()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getEmail(), getTelefone(), getCreatedAt(), getUpdatedAt());
    }

    public void setId(String id) {
        this.id = id;
    }
}
