package com.techchallenge.techchallenge.infrastructure.input.dto.pedido;

import com.techchallenge.techchallenge.core.domain.entity.pedido.PedidoStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePedidoStatusRequestDto {
    PedidoStatus status;
}
