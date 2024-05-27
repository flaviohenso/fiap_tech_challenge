package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pedido.entities;

import com.techchallenge.techchallenge.core.domain.entity.pedido.PedidoStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "pedidos")
public class PedidoEntity {
    @Id
    private String id;
    private String clientId;
    private PedidoStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime receivedAt;
    private LocalDateTime preparedAt;
    private LocalDateTime withdrawnAt;
    private List<ComboEntity> combos;
}
