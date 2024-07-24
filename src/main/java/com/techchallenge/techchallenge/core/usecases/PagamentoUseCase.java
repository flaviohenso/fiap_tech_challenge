package com.techchallenge.techchallenge.core.usecases;

import com.techchallenge.techchallenge.core.entities.Pagamento;
import com.techchallenge.techchallenge.infrastructure.input.dto.pagamento.PagamentoResponseDto;

import java.util.List;

public interface PagamentoUseCase {
    public Pagamento create(Pagamento pagamento);

    public Pagamento pagar(Pagamento pagamento);

    public Pagamento persistirPagamento(Pagamento pagamento);

    public PagamentoResponseDto gerarResponse(Pagamento pagamento);

    public List<Pagamento> findAll();
}
