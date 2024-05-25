package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.entity.PagamentoEntity;

@Repository
public interface MongoPagamentoRepository extends MongoRepository<PagamentoEntity, UUID> {
}
