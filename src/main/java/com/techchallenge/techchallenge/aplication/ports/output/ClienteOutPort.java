package com.techchallenge.techchallenge.aplication.ports.output;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.techchallenge.techchallenge.core.domain.entity.Cliente;

public interface ClienteOutPort {

    public List<Cliente> getAll();

    public Optional<Cliente> getById(UUID id);

    public Cliente save(Cliente cliente);

    public void delete(UUID uuid);

    public List<Cliente> getByCPF(String cpf);    
}
