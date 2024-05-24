package com.techchallenge.techchallenge.infrastructure.input.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techchallenge.techchallenge.aplication.usecases.ClienteUseCase;
import com.techchallenge.techchallenge.core.domain.dto.ClienteDtoMapper;
import com.techchallenge.techchallenge.core.domain.dto.UpsertClienteRequestDto;
import com.techchallenge.techchallenge.core.domain.entity.Cliente;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    final private ClienteUseCase clienteUseCase;

    final private ClienteDtoMapper mapper;

    public ClienteController(ClienteUseCase clienteUseCase, ClienteDtoMapper mapper) {
        this.clienteUseCase = clienteUseCase;
        this.mapper = mapper;
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> getAllClientes(
            @RequestParam(value = "cpf", required = false) String cpf
    ) {
        return ResponseEntity.ok().body(clienteUseCase.findAll(cpf));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") String id) {
        var uuid = UUID.fromString(id);
        return ResponseEntity.ok().body(clienteUseCase.findById(uuid));
    }

    @Operation(summary = "Cria novo cliente",
            description = "Cria um novo cliente na base de dados. Em caso do CPF já existir retorna um erro.")
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody UpsertClienteRequestDto cliente) {
        Cliente createdCliente = clienteUseCase.create(mapper.fromDto(cliente));
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(
            @PathVariable("id") String id,
            @RequestBody UpsertClienteRequestDto clienteDto
    ) {
        var cliente = mapper.fromDto(clienteDto);
        cliente.setId(UUID.fromString(id));
        Cliente createdCliente = clienteUseCase.update(cliente);
        return new ResponseEntity<>(createdCliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") String id) {
        var uuid = UUID.fromString(id);
        clienteUseCase.delete(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
