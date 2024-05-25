package com.techchallenge.techchallenge.aplication.usecases;

import com.techchallenge.techchallenge.core.domain.dto.PagamentoRequestDto;
import com.techchallenge.techchallenge.core.domain.entity.Pagamento;

public interface PagamentoUseCase {

    public Pagamento create(PagamentoRequestDto pagamento);

    public Pagamento pagar(Pagamento pagamento);

    public Pagamento persistirPagamento(Pagamento pagamento);

}
