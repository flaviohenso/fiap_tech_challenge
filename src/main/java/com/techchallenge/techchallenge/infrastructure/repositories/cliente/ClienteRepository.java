package com.techchallenge.techchallenge.infrastructure.repositories.cliente;

import com.techchallenge.techchallenge.core.domain.entity.Cliente;
import com.techchallenge.techchallenge.infrastructure.repositories.cliente.entities.ClienteEntityMapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ClienteRepository implements IClienteRepository {

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
