package com.techchallenge.techchallenge.aplication.controllers.cliente;

import com.techchallenge.techchallenge.aplication.controllers.cliente.dto.ClienteDtoMapper;
import com.techchallenge.techchallenge.aplication.controllers.cliente.dto.UpsertClienteRequestDto;
import com.techchallenge.techchallenge.aplication.usecases.ClienteUseCases;
import com.techchallenge.techchallenge.core.domain.entity.Cliente;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/clientes")
@AllArgsConstructor
public class ClienteController {

    final private ClienteUseCases clienteUseCases;

    final private ClienteDtoMapper mapper;

    @GetMapping()
    public ResponseEntity<List<Cliente>> getAllClientes(
            @RequestParam(value = "cpf", required = false) String cpf
    ) {
        return ResponseEntity.ok().body(clienteUseCases.findAll(cpf));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") String id) {
        var uuid = UUID.fromString(id);
        return ResponseEntity.ok().body(clienteUseCases.findById(uuid));
    }

    @Operation(summary = "Cria novo cliente",
            description = "Cria um novo cliente na base de dados. Em caso do CPF já existir retorna um erro.")
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody UpsertClienteRequestDto cliente) {
        Cliente createdCliente = clienteUseCases.create(mapper.fromDto(cliente));
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(
            @PathVariable("id") String id,
            @RequestBody UpsertClienteRequestDto clienteDto
    ) {
        var cliente = mapper.fromDto(clienteDto);
        cliente.setId(UUID.fromString(id));
        Cliente createdCliente = clienteUseCases.update(cliente);
        return new ResponseEntity<>(createdCliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") String id) {
        var uuid = UUID.fromString(id);
        clienteUseCases.delete(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
