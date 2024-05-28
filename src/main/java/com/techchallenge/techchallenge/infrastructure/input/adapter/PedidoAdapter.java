package com.techchallenge.techchallenge.infrastructure.input.adapter;

import com.techchallenge.techchallenge.aplication.usecases.PedidoUseCase;
import com.techchallenge.techchallenge.core.domain.entity.pedido.Pedido;
import com.techchallenge.techchallenge.infrastructure.input.dto.pedido.CriarPedidoRequestDto;
import com.techchallenge.techchallenge.infrastructure.input.dto.pedido.PedidoDtoMapper;
import com.techchallenge.techchallenge.infrastructure.input.dto.pedido.UpdatePedidoStatusRequestDto;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Operation(summary = "Listar todos os pedido", description = "Lista todos os pedidos passando um status como parâmetro opcional")
    @GetMapping()
    public ResponseEntity<List<Pedido>> getPedidos(
            @RequestParam(value = "status", required = false) String status
    ) {
        return ResponseEntity.ok().body(pedidoUseCase.findAll(status));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pedido> patchPedidoStatus(
            @PathVariable("id") String id,
            @RequestBody UpdatePedidoStatusRequestDto updatePedidoStatusRequestDto
    ) {
        Pedido pedido = pedidoUseCase.updateStatus(id, updatePedidoStatusRequestDto.getStatus());
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
}
