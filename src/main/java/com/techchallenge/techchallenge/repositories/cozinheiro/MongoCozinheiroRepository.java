package com.techchallenge.techchallenge.repositories.cozinheiro;

import com.techchallenge.techchallenge.repositories.cozinheiro.entity.CozinheiroEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MongoCozinheiroRepository extends MongoRepository<CozinheiroEntity, UUID> {
}
