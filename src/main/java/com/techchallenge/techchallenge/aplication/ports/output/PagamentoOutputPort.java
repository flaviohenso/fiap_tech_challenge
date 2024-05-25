package com.techchallenge.techchallenge.aplication.ports.output;

import java.util.List;

import com.techchallenge.techchallenge.core.domain.entity.Pagamento;

public interface PagamentoOutputPort {
    public List<Pagamento> getAll();
    public Pagamento create(Pagamento pagamento) ;  
}
