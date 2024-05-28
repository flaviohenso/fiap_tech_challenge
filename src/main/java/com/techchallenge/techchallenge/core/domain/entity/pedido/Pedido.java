package com.techchallenge.techchallenge.core.domain.entity.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;



public class Pedido {
    private String id;
    private PedidoStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;
    private String clientId;
    private List<Combo> combos;

    public Pedido() {
        this.clientId = clientId;
        this.combos = combos;
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.lastUpdatedAt = LocalDateTime.now();
        this.status = PedidoStatus.INICIAL;
    }

    public BigDecimal getTotalPrice() {
        return combos.stream().map(Combo::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }

    public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setCombos(List<Combo> combos) {
        this.combos = combos;
    }

    public String getId() {
        return id;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public String getClientId() {
        return clientId;
    }

    public List<Combo> getCombos() {
        return combos;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Pedido)) return false;
        final Pedido other = (Pedido) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$lastUpdatedAt = this.getLastUpdatedAt();
        final Object other$lastUpdatedAt = other.getLastUpdatedAt();
        if (this$lastUpdatedAt == null ? other$lastUpdatedAt != null : !this$lastUpdatedAt.equals(other$lastUpdatedAt))
            return false;
        final Object this$clientId = this.getClientId();
        final Object other$clientId = other.getClientId();
        if (this$clientId == null ? other$clientId != null : !this$clientId.equals(other$clientId)) return false;
        final Object this$combos = this.getCombos();
        final Object other$combos = other.getCombos();
        if (this$combos == null ? other$combos != null : !this$combos.equals(other$combos)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Pedido;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $lastUpdatedAt = this.getLastUpdatedAt();
        result = result * PRIME + ($lastUpdatedAt == null ? 43 : $lastUpdatedAt.hashCode());
        final Object $clientId = this.getClientId();
        result = result * PRIME + ($clientId == null ? 43 : $clientId.hashCode());
        final Object $combos = this.getCombos();
        result = result * PRIME + ($combos == null ? 43 : $combos.hashCode());
        return result;
    }
}
