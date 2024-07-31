package com.techchallenge.techchallenge.core.requests.pedido;

import com.techchallenge.techchallenge.core.entities.pedido.PedidoStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarPedidoStatusDto {
    PedidoStatus status;
}
