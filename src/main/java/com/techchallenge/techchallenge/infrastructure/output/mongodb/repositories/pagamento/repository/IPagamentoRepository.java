package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.repository;

import java.util.List;

import com.techchallenge.techchallenge.core.domain.entity.Pagamento;

public interface IPagamentoRepository {
    List<Pagamento> getAll();
    Pagamento create(Pagamento cozinheiro);
}
