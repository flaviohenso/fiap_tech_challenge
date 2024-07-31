package com.techchallenge.techchallenge.core.requests.pedido;

import java.util.List;

public class CriarPedidoDto {
    private final String clientId;
    private final List<CriarComboDto> combos;

    public CriarPedidoDto(String clientId, List<CriarComboDto> combos) {
        this.clientId = clientId;
        this.combos = combos;
    }

    public String getClientId() {
        return clientId;
    }

    public List<CriarComboDto> getCombos() {
        return combos;
    }
}
