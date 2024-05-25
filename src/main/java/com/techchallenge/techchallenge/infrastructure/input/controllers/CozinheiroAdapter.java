package com.techchallenge.techchallenge.infrastructure.input.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techchallenge.techchallenge.aplication.usecases.CozinheiroUseCase;
import com.techchallenge.techchallenge.core.domain.entity.Cozinheiro;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/cozinheiro")
@AllArgsConstructor
public class CozinheiroAdapter {

    private CozinheiroUseCase cozinheiroUseCases;

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

