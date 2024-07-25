package com.techchallenge.techchallenge.core.entities.cliente;

import com.techchallenge.techchallenge.core.exceptions.InvalidClienteException;

import java.time.OffsetDateTime;
import java.util.Objects;

public class ClienteEntity {
    private final String id;
    private final String nome;
    private final String cpf;
    private String email;
    private String telefone;
    private final OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public ClienteEntity(
            String id,
            String nome,
            String cpf,
            String email,
            String telefone,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt
    ) {
        validate(nome, cpf, email, telefone);

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private void validate(String nome, String cpf, String email, String telefone) {
        if (nome == null || nome.isBlank()) throw new InvalidClienteException("nome de cliente invalido");
        if (cpf == null || cpf.isBlank()) throw new InvalidClienteException("cpf de cliente invalido");
        if (email == null || email.isBlank()) throw new InvalidClienteException("email de cliente invalido");
        if (telefone == null || telefone.isBlank()) throw new InvalidClienteException("telefone de cliente invalido");
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
        ClienteEntity that = (ClienteEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getCpf(), that.getCpf()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getTelefone(), that.getTelefone()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt()) && Objects.equals(getCreatedAt(), that.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getEmail(), getTelefone(), getUpdatedAt(), getCreatedAt());
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOffsetDateTime(OffsetDateTime now) {
        this.updatedAt = now;
    }
}
