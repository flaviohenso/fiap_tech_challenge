package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento;

import com.techchallenge.techchallenge.aplication.ports.output.PagamentoOutputPort;
import com.techchallenge.techchallenge.core.entities.Pagamento;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.mapper.PagamentoEntityMapper;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.repository.MongoPagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PagamentoMongoAdapter implements PagamentoOutputPort {

    private final PagamentoEntityMapper mapper;

    private final MongoPagamentoRepository repository;

    @Override
    public List<Pagamento> getAll() {
        return repository.findAll().stream().map(mapper::fromEntity).toList();
    }

    @Override
    public Pagamento create(Pagamento pagamento) {
        return Optional.of(pagamento)
                .map(mapper::toEntity)
                .map(repository::save)
                .map(mapper::fromEntity)
                .orElse(null);
    }
}
