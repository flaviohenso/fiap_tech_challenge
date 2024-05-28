package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.repository;

import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.entity.PedidoEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoMongoRepository extends MongoRepository<PedidoEntity, String> {
    List<PedidoEntity> findByStatus(String status, Sort sort);
}
