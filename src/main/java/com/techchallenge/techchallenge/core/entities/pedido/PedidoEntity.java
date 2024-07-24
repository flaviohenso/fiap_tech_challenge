package com.techchallenge.techchallenge.core.entities.pedido;

import com.techchallenge.techchallenge.core.exceptions.InvalidPedidoException;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;


public class PedidoEntity {
    private final String id;
    private PedidoStatus status;
    private final String clientId;
    private final List<ComboEntity> combos;
    private final OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;


    public PedidoEntity(
            String id,
            PedidoStatus status,
            String clientId,
            List<ComboEntity> combos,
            OffsetDateTime createdAt,
            OffsetDateTime updatedAt
    ) {
        validate(clientId, combos);

        this.id = id;
        this.status = status;
        this.clientId = clientId;
        this.combos = combos;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private void validate(String clientId, List<ComboEntity> comboEntities) {
        if (clientId.isBlank())
            throw new InvalidPedidoException("id de cliente invalido");

        if (comboEntities == null || comboEntities.isEmpty())
            throw new InvalidPedidoException("Pedido precisa ter pelo menos um combo");
    }

    public BigDecimal getTotalPrice() {
        return combos.stream().map(ComboEntity::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
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

    public List<ComboEntity> getCombos() {
        return combos;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setStatus(PedidoStatus novoStatus) {
        this.status = novoStatus;
    }

    public void setUpdatedAt(OffsetDateTime now) {
        this.updatedAt = now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoEntity that = (PedidoEntity) o;
        return Objects.equals(getId(), that.getId()) && getStatus() == that.getStatus() && Objects.equals(getClientId(), that.getClientId()) && Objects.equals(getCombos(), that.getCombos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus(), getClientId(), getCombos());
    }
}
