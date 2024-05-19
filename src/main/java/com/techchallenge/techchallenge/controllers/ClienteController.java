package com.techchallenge.techchallenge.controllers;

import com.techchallenge.techchallenge.domain.entity.Cliente;
import com.techchallenge.techchallenge.usecases.ClienteUseCases;
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

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteUseCases.create(cliente);
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(
            @PathVariable("id") String id,
            @RequestBody Cliente cliente
    ) {
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
