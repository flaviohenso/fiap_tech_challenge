package com.techchallenge.techchallenge.api.handlers;

import com.techchallenge.techchallenge.adapters.controller.cliente.ClienteController;
import com.techchallenge.techchallenge.core.entities.cliente.ClienteEntity;
import com.techchallenge.techchallenge.core.requests.cliente.AtualizarClienteDto;
import com.techchallenge.techchallenge.core.requests.cliente.CriarClienteDto;
import com.techchallenge.techchallenge.external.datasource.mongodb.ClienteMongoDbDataSource;
import com.techchallenge.techchallenge.pkg.interfaces.IClienteDataSource;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteHandler {
    private final String mongoConnection;

    private final String mongoDatabase;

    public ClienteHandler(
            @Value("${mongo.connection}") String mongoConnection,
            @Value("${mongo.database}") String mongoDatabase) {
        this.mongoConnection = mongoConnection;
        this.mongoDatabase = mongoDatabase;
    }

    @Operation(summary = "Cria novo cliente",
            description = "Cria um novo cliente na base de dados. Em caso do CPF já existir retorna um erro.")
    @PostMapping
    public ResponseEntity<ClienteEntity> create(@RequestBody CriarClienteDto dto) {
        IClienteDataSource dataSource = new ClienteMongoDbDataSource(mongoConnection, mongoDatabase);
        ClienteController controller = new ClienteController(dataSource);

        ClienteEntity cliente = controller.cadastrarCliente(dto);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ClienteEntity>> getAll(
            @RequestParam(value = "cpf", required = false) String cpf
    ) {
        IClienteDataSource dataSource = new ClienteMongoDbDataSource(mongoConnection, mongoDatabase);
        ClienteController controller = new ClienteController(dataSource);

        List<ClienteEntity> clientes = controller.buscarTodos(cpf);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> getById(@PathVariable("id") String id) {
        IClienteDataSource dataSource = new ClienteMongoDbDataSource(mongoConnection, mongoDatabase);
        ClienteController controller = new ClienteController(dataSource);

        ClienteEntity cliente = controller.getById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        IClienteDataSource dataSource = new ClienteMongoDbDataSource(mongoConnection, mongoDatabase);
        ClienteController controller = new ClienteController(dataSource);

        controller.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Atualizar cliente",
            description = "Atualiza dados do cliente na base de dados.")
    @PatchMapping("/{id}")
    public ResponseEntity<ClienteEntity> atualizar(
            @PathVariable("id") String id,
            @RequestBody AtualizarClienteDto dto
    ) {
        IClienteDataSource dataSource = new ClienteMongoDbDataSource(mongoConnection, mongoDatabase);
        ClienteController controller = new ClienteController(dataSource);

        ClienteEntity cliente = controller.atualizar(id, dto);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
}
