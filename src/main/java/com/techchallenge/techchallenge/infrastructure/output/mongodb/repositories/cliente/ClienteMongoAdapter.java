package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.techchallenge.techchallenge.aplication.ports.output.ClienteOutputPort;
import com.techchallenge.techchallenge.core.domain.entity.Cliente;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.mappers.ClienteEntityMapper;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.repository.MongoClienteRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ClienteMongoAdapter implements ClienteOutputPort{

    private final ClienteEntityMapper mapper;

    private final MongoClienteRepository repository;   

    @Override
    public List<Cliente> getAll() {
        return repository.findAll().stream().map(mapper::fromEntity).toList();
    }

    @Override
    public Optional<Cliente> getById(UUID id) {
        return repository.findById(id).map(mapper::fromEntity);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return Optional.of(cliente)
                .map(mapper::toEntity)
                .map(repository::save)
                .map(mapper::fromEntity)
                .orElse(null);
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public List<Cliente> getByCPF(String cpf) {
        return repository.findByCpf(cpf).stream().map(mapper::fromEntity).toList();
    }
}
