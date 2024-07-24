package com.techchallenge.techchallenge.infrastructure.input.adapter;

import com.techchallenge.techchallenge.core.entities.Cliente;
import com.techchallenge.techchallenge.core.usecases.ClienteUseCase;
import com.techchallenge.techchallenge.infrastructure.input.dto.cliente.ClienteDtoMapper;
import com.techchallenge.techchallenge.infrastructure.input.dto.cliente.ClienteRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteAdapter {

    private ClienteUseCase clienteUseCase;

    private ClienteDtoMapper mapper;

    public ClienteAdapter(ClienteUseCase clienteUseCase, ClienteDtoMapper mapper) {
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
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteRequestDto cliente) {
        Cliente createdCliente = clienteUseCase.create(mapper.fromDto(cliente));
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(
            @PathVariable("id") String id,
            @RequestBody ClienteRequestDto clienteDto
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
