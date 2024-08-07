package com.techchallenge.techchallenge.api.handlers;

import com.techchallenge.techchallenge.adapters.controller.produto.ProdutoController;
import com.techchallenge.techchallenge.core.entities.produto.Categoria;
import com.techchallenge.techchallenge.core.entities.produto.ProdutoEntity;
import com.techchallenge.techchallenge.core.requests.produto.AtualizarProdutoDto;
import com.techchallenge.techchallenge.core.requests.produto.CriarProdutoDto;
import com.techchallenge.techchallenge.external.datasource.mongodb.ProdutoMongoDbDataSource;
import com.techchallenge.techchallenge.pkg.interfaces.IProdutoDataSource;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoHandler {
    private final ProdutoController produtoController;

    public ProdutoHandler(
            @Value("${mongo.connection}") String mongoConnection,
            @Value("${mongo.database}") String mongoDatabase) {
        IProdutoDataSource dataSource = new ProdutoMongoDbDataSource(mongoConnection, mongoDatabase);
        this.produtoController = new ProdutoController(dataSource);
    }

    @Operation(summary = "Cria novo produto",
            description = "Cria um novo produto na base de dados.")
    @PostMapping
    public ResponseEntity<ProdutoEntity> create(@RequestBody CriarProdutoDto dto) {
        ProdutoEntity produto = produtoController.cadastrarProduto(dto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ProdutoEntity>> getAll(
            @RequestParam(value = "categoria", required = false) String categoriaValue
    ) {
        Categoria categoria = Optional.ofNullable(categoriaValue)
                .map(String::toUpperCase)
                .map(Categoria::valueOf)
                .orElse(null);

        List<ProdutoEntity> clientes = produtoController.buscarTodos(categoria);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoEntity> getById(@PathVariable("id") String id) {
        ProdutoEntity produto = produtoController.buscarPorId(id);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        produtoController.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Atualizar produto",
            description = "Atualiza dados do produto na base de dados.")
    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoEntity> atualizar(
            @PathVariable("id") String id,
            @RequestBody AtualizarProdutoDto dto
    ) {
        ProdutoEntity produto = produtoController.atualizar(id, dto);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
}
