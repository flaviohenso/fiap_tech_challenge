package com.techchallenge.techchallenge.adapters.gateway.pagamento;

import com.techchallenge.techchallenge.adapters.gateway.pagamento.mapper.PagamentoMapper;
import com.techchallenge.techchallenge.core.entities.pagamento.PagamentoEntity;
import com.techchallenge.techchallenge.core.exceptions.InvalidPagamentoException;
import com.techchallenge.techchallenge.pkg.dto.PagamentoDto;
import com.techchallenge.techchallenge.pkg.interfaces.IPagamentoDataSource;

import java.util.Optional;

public class PagamentoGateway {

    private final IPagamentoDataSource dataSource;

    public PagamentoGateway(IPagamentoDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public PagamentoEntity criarPagamento(PagamentoEntity pagamento) {
        if (pagamento.getId() != null) throw new InvalidPagamentoException("Pagamento já existente");

        PagamentoDto savedPagamento = dataSource.insertPagamento(PagamentoMapper.toDto(pagamento));

        return PagamentoMapper.toEntity(savedPagamento);
    }

    public PagamentoEntity consultarByPedidoId(String pedidoId) {
        return Optional.ofNullable(pedidoId)
                .map(dataSource::firstPagamentoByPedidoIdSortByUpdatedAtDesc)
                .map(PagamentoMapper::toEntity)
                .orElse(null);
    }

    public PagamentoEntity consultarByExternalId(String externalId) {
        return Optional.ofNullable(externalId)
                .map(dataSource::firstPagamentoByExternalIdSortByUpdatedAtDesc)
                .map(PagamentoMapper::toEntity)
                .orElse(null);
    }

    public PagamentoEntity atualizarPagamento(PagamentoEntity pagamento) {
        PagamentoDto savedPagamento = dataSource.updatePagamento(PagamentoMapper.toDto(pagamento));
        return PagamentoMapper.toEntity(savedPagamento);
    }
}
