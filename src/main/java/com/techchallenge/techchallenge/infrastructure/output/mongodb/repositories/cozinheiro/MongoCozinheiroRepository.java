package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro.entity.CozinheiroEntity;

@Repository
public interface MongoCozinheiroRepository extends MongoRepository<CozinheiroEntity, UUID> {
}
