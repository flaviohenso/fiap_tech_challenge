package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.produto.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.produto.entity.ProdutoEntity;

@Repository
public interface MongoProdutoRepository extends MongoRepository<ProdutoEntity, UUID> {
}
