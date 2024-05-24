package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.techchallenge.techchallenge.core.domain.entity.Cliente;

public interface IClienteRepository {
    List<Cliente> getAll();

    Optional<Cliente> getById(UUID id);

    Cliente save(Cliente cliente);

    void delete(UUID uuid);

    List<Cliente> getByCPF(String cpf);
}
