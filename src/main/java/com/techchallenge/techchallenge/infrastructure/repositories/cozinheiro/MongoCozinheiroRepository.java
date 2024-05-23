package com.techchallenge.techchallenge.infrastructure.repositories.cozinheiro;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.techchallenge.techchallenge.infrastructure.repositories.cozinheiro.entity.CozinheiroEntity;

import java.util.UUID;

@Repository
public interface MongoCozinheiroRepository extends MongoRepository<CozinheiroEntity, UUID> {
}
