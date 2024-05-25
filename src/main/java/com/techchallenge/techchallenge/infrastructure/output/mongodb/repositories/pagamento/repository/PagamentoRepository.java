package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.repository;

import java.util.List;

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
        return mapper.fromEntity(
                repository.save(mapper.toEntity(pagamento))
        );
    }
}
