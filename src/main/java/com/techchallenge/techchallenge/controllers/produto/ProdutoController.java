package com.techchallenge.techchallenge.controllers.produto;
import com.techchallenge.techchallenge.controllers.produto.dto.ProdutoDtoMapper;
import com.techchallenge.techchallenge.controllers.produto.dto.UpsertProdutoRequestDto;
import com.techchallenge.techchallenge.domain.entity.Produto;
import com.techchallenge.techchallenge.usecases.ProdutoUseCases;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/produtos")
@AllArgsConstructor
public class ProdutoController {

    final private ProdutoUseCases produtoUseCases;

    final private ProdutoDtoMapper mapper;

    @GetMapping()
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> produtos = produtoUseCases.findAll(); // Chama o método findAll de ProdutoUseCases
        return new ResponseEntity<>(produtos, HttpStatus.OK); // Retorna a lista de produtos com status OK
    }

    @Operation(summary = "Cria novo produto",
            description = "Cria um novo produto na base de dados.")

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody UpsertProdutoRequestDto produto) {
        Produto createdProduto = produtoUseCases.create(mapper.fromDto(produto));
        return new ResponseEntity<>(createdProduto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateCliente(
            @PathVariable("id") String id,
            @RequestBody UpsertProdutoRequestDto produtoDto
    ) {
        var produto = mapper.fromDto(produtoDto);
        produto.setId(UUID.fromString(id));
        Produto createdProduto = produtoUseCases.update(produto);
        return new ResponseEntity<>(createdProduto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable("id") String id) {
        var uuid = UUID.fromString(id);
        produtoUseCases.delete(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
