package com.techchallenge.techchallenge.core.domain.entity;

import java.util.UUID;

import com.techchallenge.techchallenge.core.domain.vo.Id;

public class Cozinheiro {
    private UUID id;
    private String nome;

    public Cozinheiro() {
    }

    public Cozinheiro(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cozinheiro)) return false;

        Cozinheiro that = (Cozinheiro) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return nome != null ? nome.equals(that.nome) : that.nome == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }
}
