package com.techchallenge.techchallenge.aplication.ports.output;

import com.techchallenge.techchallenge.core.entities.Pagamento;

import java.util.List;

public interface PagamentoOutputPort {
    public List<Pagamento> getAll();

    public Pagamento create(Pagamento pagamento);
}
