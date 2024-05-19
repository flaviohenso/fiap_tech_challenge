package com.techchallenge.techchallenge.repositories.cliente;

import com.techchallenge.techchallenge.repositories.cliente.entities.ClienteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MongoClienteRepository extends MongoRepository<ClienteEntity, UUID> {
    List<ClienteEntity> findByCpf(String cpf);
}
