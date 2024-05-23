package com.techchallenge.techchallenge.infrastructure.repositories.cliente;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.techchallenge.techchallenge.infrastructure.repositories.cliente.entities.ClienteEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface MongoClienteRepository extends MongoRepository<ClienteEntity, UUID> {
    List<ClienteEntity> findByCpf(String cpf);
}
