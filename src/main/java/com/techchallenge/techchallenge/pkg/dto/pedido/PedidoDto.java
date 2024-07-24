package com.techchallenge.techchallenge.pkg.dto.pedido;

import com.techchallenge.techchallenge.core.entities.pedido.PedidoStatus;

import java.time.OffsetDateTime;
import java.util.List;

public class PedidoDto {
    private String id;
    private final PedidoStatus status;
    private final String clientId;
    private final List<ComboDto> combos;
    private final OffsetDateTime createdAt;
    private final OffsetDateTime updatedAt;

    public PedidoDto(String id, PedidoStatus status, String clientId, List<ComboDto> combos, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.status = status;
        this.clientId = clientId;
        this.combos = combos;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public String getClientId() {
        return clientId;
    }

    public List<ComboDto> getCombos() {
        return combos;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(String id) {
        this.id = id;
    }
}
