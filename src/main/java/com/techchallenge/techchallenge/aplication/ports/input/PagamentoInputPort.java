package com.techchallenge.techchallenge.aplication.ports.input;

import com.techchallenge.techchallenge.aplication.ports.output.PagamentoOutputPort;
import com.techchallenge.techchallenge.aplication.usecases.PagamentoUseCase;
import com.techchallenge.techchallenge.core.domain.dto.PagamentoRequestDto;
import com.techchallenge.techchallenge.core.domain.entity.Pagamento;
import com.techchallenge.techchallenge.core.domain.vo.StatusPagamento;

public class PagamentoInputPort implements PagamentoUseCase {

    private PagamentoOutputPort pagamentoOutputPort;

    public PagamentoInputPort(PagamentoOutputPort pagamentoOutputPort){
        this.pagamentoOutputPort = pagamentoOutputPort;
    }

    @Override
    public Pagamento create(PagamentoRequestDto pagamento) {
        return new Pagamento.Builder()
                .withNumeroPedido(pagamento.getNumeroPedido())
                .withCanal(pagamento.getCanal())
                .withDataPagamento(pagamento.getDataPagamento())
                .withIdCliente(pagamento.getIdCliente())
                .withObservacao(pagamento.getObservacao())
                // .withId(pagamento.getId())
                .withValor(pagamento.getValor())
                .withStatus(StatusPagamento.PENDENTE)
                .build();
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
        pagamento.updateStatus(StatusPagamento.PAGO);
        return pagamento;
    }

    @Override
    public Pagamento persistirPagamento(Pagamento pagamento) {
        return pagamentoOutputPort.create(pagamento);
    }

  


}
