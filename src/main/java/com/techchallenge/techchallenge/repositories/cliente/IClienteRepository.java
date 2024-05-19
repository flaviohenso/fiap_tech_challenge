package com.techchallenge.techchallenge.repositories.cliente;

import com.techchallenge.techchallenge.domain.entity.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IClienteRepository {
    List<Cliente> getAll();

    Optional<Cliente> getById(UUID id);

    Cliente save(Cliente cliente);

    void delete(UUID uuid);

    List<Cliente> getByCPF(String cpf);
}
