package com.techchallenge.techchallenge.aplication.ports.input;

import java.util.List;

import com.techchallenge.techchallenge.aplication.ports.output.PagamentoOutputPort;
import com.techchallenge.techchallenge.aplication.usecases.PagamentoUseCase;
import com.techchallenge.techchallenge.core.domain.entity.Pagamento;
import com.techchallenge.techchallenge.core.domain.vo.StatusPagamento;
import com.techchallenge.techchallenge.infrastructure.input.dto.pagamento.PagamentoResponseDto;

public class PagamentoInputPort implements PagamentoUseCase {

    private PagamentoOutputPort pagamentoOutputPort;

    public PagamentoInputPort(PagamentoOutputPort pagamentoOutputPort){
        this.pagamentoOutputPort = pagamentoOutputPort;
    }

    @Override
    public Pagamento create(Pagamento pagamento) {
        return pagamento;
    }

    @Override
    public Pagamento pagar(Pagamento pagamento) {
        //simulando o pagamento
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //atualiza o status do pagamento
        pagamento.updateStatus(StatusPagamento.APROVADO);
        return pagamento;
    }

    @Override
    public Pagamento persistirPagamento(Pagamento pagamento) {
        return pagamentoOutputPort.create(pagamento);
    }

    @Override
    public PagamentoResponseDto gerarResponse(Pagamento pagamento) {
        return new PagamentoResponseDto(
            pagamento.getNumeroPedido(), pagamento.getValor(),
            pagamento.getObservacao(), pagamento.getDataPagamento(),
            pagamento.getIdCliente(),
            pagamento.getCanal(), pagamento.getStatus().getValue());
    }

    @Override
    public List<Pagamento> findAll() {
        return pagamentoOutputPort.getAll();
    }

  


}
