package com.techchallenge.techchallenge.core.domain.entity.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    private String id;
    private PedidoStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime receivedAt;
    private LocalDateTime preparedAt;
    private LocalDateTime withdrawnAt;
    private String clientId;
    private List<Combo> combos;

}
