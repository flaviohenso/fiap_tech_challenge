package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido;

import com.techchallenge.techchallenge.aplication.ports.output.PedidoOutputPort;
import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.entity.PedidoEntity;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.mapper.PedidoEntityMapper;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.repository.PedidoMongoRepository;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PedidoMongoAdapter implements PedidoOutputPort {

    private PedidoMongoRepository repository;
    private PedidoEntityMapper mapper;

    @Override
    public Pedido savePedido(Pedido pedido) {
        return Optional.of(pedido)
                .map(mapper::toEntity)
                .map(repository::save)
                .map(mapper::fromEntity)
                .orElse(null);
    }

    @Override
    public List<Pedido> findAll(String status) {
        Sort sort = Sort.by(Sort.Direction.ASC, "createdAt");
        List<PedidoEntity> pedidoEntities;
        if (status == null) {
            pedidoEntities = repository.findAll(sort);
        } else {
            pedidoEntities = repository.findByStatus(status, sort);
        }
        return pedidoEntities.stream().map(mapper::fromEntity).toList();
    }

    @Override
    public Optional<Pedido> findById(String id) {
        return repository.findById(id)
                .map(mapper::fromEntity);
    }
}
