package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.techchallenge.techchallenge.core.domain.entity.Pagamento;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.mapper.PagamentoEntityMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PagamentoRepository implements IPagamentoRepository {

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
