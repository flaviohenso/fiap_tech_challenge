package com.techchallenge.techchallenge.api.handlers;

import com.techchallenge.techchallenge.adapters.controller.PedidoController;
import com.techchallenge.techchallenge.core.entities.pedido.PedidoEntity;
import com.techchallenge.techchallenge.core.requests.AtualizarPedidoStatusDto;
import com.techchallenge.techchallenge.core.requests.CriarPedidoDto;
import com.techchallenge.techchallenge.external.datasource.mongodb.PedidoMongoDbDataSource;
import com.techchallenge.techchallenge.pkg.interfaces.IPedidoDataSource;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/pedidos")
public class PedidoHandler {
    private final String mongoConnection;

    private final String mongoDatabase;

    public PedidoHandler(
            @Value("${mongo.connection}") String mongoConnection,
            @Value("${mongo.database}") String mongoDatabase) {
        this.mongoConnection = mongoConnection;
        this.mongoDatabase = mongoDatabase;
    }

    @Operation(summary = "Cria novo pedido", description = "Cria um novo pedido na base de dados.")
    @PostMapping
    public ResponseEntity<PedidoEntity> create(@RequestBody CriarPedidoDto dto) {
        IPedidoDataSource dataSource = new PedidoMongoDbDataSource(mongoConnection, mongoDatabase);
        PedidoController controller = new PedidoController(dataSource);

        PedidoEntity pedido = controller.cadastrarPedido(dto);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @Operation(summary = "Busca pedido por id", description = "Busca pedido usando identificador na base de dados.")
    @GetMapping("/{id}")
    public ResponseEntity<PedidoEntity> getPedidoById(
            @PathVariable("id") String id
    ) {
        IPedidoDataSource dataSource = new PedidoMongoDbDataSource(mongoConnection, mongoDatabase);
        PedidoController controller = new PedidoController(dataSource);

        return Optional.of(id)
                .map(controller::getById)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build())
                ;
    }

    @Operation(summary = "Listar todos os pedidos", description = "Lista todos os pedidos passando um status como parâmetro opcional")
    @GetMapping()
    public ResponseEntity<List<PedidoEntity>> getPedidos(
            @RequestParam(value = "status", required = false) String status
    ) {
        IPedidoDataSource dataSource = new PedidoMongoDbDataSource(mongoConnection, mongoDatabase);
        PedidoController controller = new PedidoController(dataSource);
        List<PedidoEntity> pedidos = controller.getAll();

        return ResponseEntity.ok().body(pedidos);
    }

    @Operation(summary = "Atualiza status do pedido por id", description = "Atualizar status do pedido na base de dados por id.")
    @PatchMapping("/{id}")
    public ResponseEntity<PedidoEntity> patchPedidoStatus(
            @PathVariable("id") String id,
            @RequestBody AtualizarPedidoStatusDto atualizarPedidoStatusDto
    ) {
        IPedidoDataSource dataSource = new PedidoMongoDbDataSource(mongoConnection, mongoDatabase);
        PedidoController controller = new PedidoController(dataSource);

        PedidoEntity pedido = controller.atualizarStatus(id, atualizarPedidoStatusDto.getStatus());
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
}
