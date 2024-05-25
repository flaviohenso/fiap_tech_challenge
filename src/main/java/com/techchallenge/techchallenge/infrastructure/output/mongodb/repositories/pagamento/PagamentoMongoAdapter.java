package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techchallenge.techchallenge.aplication.ports.output.PagamentoOutputPort;
import com.techchallenge.techchallenge.core.domain.entity.Pagamento;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.repository.PagamentoRepository;

@Component
public class PagamentoMongoAdapter implements PagamentoOutputPort {

    private PagamentoRepository repository;

    public PagamentoMongoAdapter(PagamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pagamento> getAll() {
        var pagamentos = repository.getAll();
        return pagamentos;
    }

    @Override
    public Pagamento create(Pagamento pagamento) {
        var created = repository.create(pagamento);
        return created;
    }  
    
}
