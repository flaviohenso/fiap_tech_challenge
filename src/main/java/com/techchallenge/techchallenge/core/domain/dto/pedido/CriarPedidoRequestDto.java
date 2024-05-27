package com.techchallenge.techchallenge.core.domain.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarPedidoRequestDto {
    String clientId;
    List<ComboRequestDto> combos;
}
