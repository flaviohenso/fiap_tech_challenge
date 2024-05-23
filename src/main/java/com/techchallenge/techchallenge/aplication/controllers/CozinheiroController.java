package com.techchallenge.techchallenge.aplication.controllers;

import com.techchallenge.techchallenge.aplication.usecases.CozinheiroUseCases;
import com.techchallenge.techchallenge.core.domain.entity.Cozinheiro;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cozinheiro")
@AllArgsConstructor
public class CozinheiroController {

    final private CozinheiroUseCases cozinheiroUseCases;

    @GetMapping()
    public ResponseEntity<List<Cozinheiro>> getAllCozinheiros() {
        return ResponseEntity.ok().body(cozinheiroUseCases.findAll());
    }

    @PostMapping
    public ResponseEntity<Cozinheiro> createCozinheiro(@RequestBody Cozinheiro cozinheiro) {
        Cozinheiro createdcozinheiro = cozinheiroUseCases.create(cozinheiro);
        return new ResponseEntity<>(createdcozinheiro, HttpStatus.CREATED);
    }
}

