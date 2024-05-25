package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.techchallenge.techchallenge.aplication.ports.output.ClienteOutPort;
import com.techchallenge.techchallenge.core.domain.entity.Cliente;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.repository.ClienteRepository;

@Component
public class ClienteMongoAdapter implements ClienteOutPort{
    
    private ClienteRepository repository;

    public ClienteMongoAdapter(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cliente> getAll() {
        var clientes = repository.getAll();
        return clientes;
    }

    @Override
    public Optional<Cliente> getById(UUID id) {
        var optional = repository.getById(id);
        return optional;
    }

    @Override
    public Cliente save(Cliente cliente) {
        var saved = repository.save(cliente);
        return saved;
    }

    @Override
    public void delete(UUID uuid) {
        repository.delete(uuid);
    }

    @Override
    public List<Cliente> getByCPF(String cpf) {
        var clientes = repository.getByCPF(cpf);
        return clientes;
    }

}
