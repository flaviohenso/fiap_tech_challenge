package com.techchallenge.techchallenge.aplication.ports.output;

import com.techchallenge.techchallenge.core.entities.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteOutputPort {

    public List<Cliente> getAll();

    public Optional<Cliente> getById(UUID id);

    public Cliente save(Cliente cliente);

    public void delete(UUID uuid);

    public List<Cliente> getByCPF(String cpf);
}
