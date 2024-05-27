package com.techchallenge.techchallenge.infrastructure.input.adapter;

import com.techchallenge.techchallenge.aplication.usecases.PedidoUseCase;
import com.techchallenge.techchallenge.core.domain.dto.PedidoDtoMapper;
import com.techchallenge.techchallenge.core.domain.dto.pedido.CriarPedidoRequestDto;
import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/pedidos")
@AllArgsConstructor
public class PedidoAdapter {

    private final PedidoUseCase pedidoUseCase;

    private final PedidoDtoMapper mapper;

    @Operation(summary = "Cria novo pedido", description = "Cria um novo pedido na base de dados.")
    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody CriarPedidoRequestDto dto) {
        Pedido pedido = pedidoUseCase.criarPedido(mapper.fromDto(dto));
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }
}
