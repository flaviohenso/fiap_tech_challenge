package com.techchallenge.techchallenge.repositories;

import com.techchallenge.techchallenge.domain.entity.Cozinheiro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MongoCozinheiroRepository extends MongoRepository<Cozinheiro, UUID> {
}
