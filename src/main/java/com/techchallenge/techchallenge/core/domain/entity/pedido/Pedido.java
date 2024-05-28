package com.techchallenge.techchallenge.core.domain.entity.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    private String id;
    private PedidoStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;
    private String clientId;
    private List<Combo> combos;

    public BigDecimal getTotalPrice() {
        return combos.stream().map(Combo::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
