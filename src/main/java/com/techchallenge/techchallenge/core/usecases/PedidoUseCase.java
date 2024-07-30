package com.techchallenge.techchallenge.core.usecases;

import com.techchallenge.techchallenge.adapters.gateway.pedido.PedidoGateway;
import com.techchallenge.techchallenge.core.entities.pagamento.StatusPagamento;
import com.techchallenge.techchallenge.core.entities.pedido.ComboEntity;
import com.techchallenge.techchallenge.core.entities.pedido.PedidoEntity;
import com.techchallenge.techchallenge.core.entities.pedido.PedidoStatus;
import com.techchallenge.techchallenge.core.entities.pedido.ProdutoComboEntity;
import com.techchallenge.techchallenge.core.exceptions.PedidoNotFoundException;
import com.techchallenge.techchallenge.core.requests.pedido.CriarPedidoDto;
import com.techchallenge.techchallenge.core.requests.pedido.CriarProdutoComboDto;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public class PedidoUseCase {

    private final PedidoGateway pedidoGateway;

    public PedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public PedidoEntity criarPedido(CriarPedidoDto criarPedidoDto) {
        var pedido = toPedidoEntity(criarPedidoDto);

        return pedidoGateway.criar(pedido);
    }

    private PedidoEntity toPedidoEntity(CriarPedidoDto criarPedidoDto) {
        OffsetDateTime now = OffsetDateTime.now();
        List<ComboEntity> combos = criarPedidoDto.getCombos().stream()
                .map(c -> new ComboEntity(
                        toProdutoComboEntity(c.getLanche()),
                        toProdutoComboEntity(c.getAcompanhamento()),
                        toProdutoComboEntity(c.getBebida()),
                        toProdutoComboEntity(c.getSobremesa())
                )).toList();

        return new PedidoEntity(
                null,
                PedidoStatus.INICIAL,
                criarPedidoDto.getClientId(),
                combos,
                now,
                now
        );
    }


    private ProdutoComboEntity toProdutoComboEntity(CriarProdutoComboDto criarProdutoComboDto) {
        return new ProdutoComboEntity(
                criarProdutoComboDto.getIdProduto(),
                criarProdutoComboDto.getQuantity(),
                criarProdutoComboDto.getPrice()
        );
    }

    public PedidoEntity buscarPorId(String id) {
        return pedidoGateway.getById(id);
    }

    public List<PedidoEntity> buscarTodos() {
        return pedidoGateway.findAll();
    }

    public PedidoEntity atualizarStatusCallbackPagamento(String id, StatusPagamento statusPagamento) {
        PedidoEntity pedido = buscarPorId(id);

        if (statusPagamento == StatusPagamento.APROVADO) {
            pedido.setStatus(PedidoStatus.RECEBIDO);
            pedido.setUpdatedAt(OffsetDateTime.now());

            return pedidoGateway.atualizar(pedido);
        }
        return pedido;
    }

    public PedidoEntity atualizarStatus(String id, PedidoStatus status) {
        PedidoEntity pedido = Optional.of(id)
                .map(pedidoGateway::getById)
                .orElseThrow(PedidoNotFoundException::new);

        pedido.setStatus(status);
        pedido.setUpdatedAt(OffsetDateTime.now());

        return pedidoGateway.atualizar(pedido);
    }
}
