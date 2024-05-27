package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido;

import com.techchallenge.techchallenge.aplication.ports.output.PedidoOutputPort;
import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PedidoMongoAdapter implements PedidoOutputPort {

    private PedidoMongoRepository repository;
    private PedidoEntityMapper mapper;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        return Optional.of(pedido)
                .map(mapper::toEntity)
                .map(repository::save)
                .map(mapper::fromEntity)
                .orElse(null);
    }
}
