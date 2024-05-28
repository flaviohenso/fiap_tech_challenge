package com.techchallenge.techchallenge.aplication.usecases;

import java.util.List;

import com.techchallenge.techchallenge.core.domain.entity.Pagamento;
import com.techchallenge.techchallenge.infrastructure.input.dto.pagamento.PagamentoResponseDto;

public interface PagamentoUseCase {
    public Pagamento create(Pagamento pagamento);
    public Pagamento pagar(Pagamento pagamento);
    public Pagamento persistirPagamento(Pagamento pagamento);
    public PagamentoResponseDto gerarResponse(Pagamento pagamento);
    public List<Pagamento> findAll();
}
