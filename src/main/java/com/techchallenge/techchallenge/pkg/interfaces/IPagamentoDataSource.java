package com.techchallenge.techchallenge.pkg.interfaces;

import com.techchallenge.techchallenge.pkg.dto.PagamentoDto;

public interface IPagamentoDataSource {
    PagamentoDto insertPagamento(PagamentoDto pagamento);

    PagamentoDto firstPagamentoByPedidoIdSortByUpdatedAtDesc(String pedidoId);

    PagamentoDto firstPagamentoByExternalIdSortByUpdatedAtDesc(String externalId);
    
    PagamentoDto updatePagamento(PagamentoDto pagamento);
}
