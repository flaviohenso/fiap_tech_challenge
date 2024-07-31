package com.techchallenge.techchallenge.core.exceptions;

public class PedidoNotFoundException extends RuntimeException {
    public PedidoNotFoundException() {
        super("Pedido não existe");
    }
}
