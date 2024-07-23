package com.techchallenge.techchallenge.infrastructure.input.adapter;

import com.techchallenge.techchallenge.core.entities.Produto;
import com.techchallenge.techchallenge.core.usecases.ProdutoUseCase;
import com.techchallenge.techchallenge.infrastructure.input.dto.produto.ProdutoRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoAdapter {

    private ProdutoUseCase produtoUseCase;

    public ProdutoAdapter(ProdutoUseCase produtoUseCase) {
        this.produtoUseCase = produtoUseCase;
    }

    @GetMapping()
    public ResponseEntity<List<Produto>> getAllProdutos() {
        return ResponseEntity.ok().body(produtoUseCase.listProdutos());
    }

    @Operation(summary = "Cria novo produto",
            description = "Cria um novo produto na base de dados.")
    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody ProdutoRequestDto produtoRequestDto) {

        Produto produto = produtoUseCase.mapperDtoToProduto(produtoRequestDto);
        produto = produtoUseCase.createProduto(produto);

        return ResponseEntity.ok(produtoUseCase.createProduto(produto));
    }

    @Operation(summary = "Atualiza produto",
            description = "Atualiza um produto na base de dados.")
    @PutMapping("/update")
    public ResponseEntity<Produto> updateProduto(@RequestBody ProdutoRequestDto produtoRequestDto) {

        Produto produto = produtoUseCase.mapperDtoToProduto(produtoRequestDto);
        produto = produtoUseCase.updateProduto(produto);

        return ResponseEntity.ok(produtoUseCase.updateProduto(produto));
    }

    @Operation(summary = "Remove produto",
            description = "Remove um produto na base de dados.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(String id) {
        var uuid = UUID.fromString(id);
        produtoUseCase.deleteProduto(uuid);
        return ResponseEntity.noContent().build();
    }

}
