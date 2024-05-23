package com.techchallenge.techchallenge.infrastructure.repositories.cozinheiro.entity;

import org.mapstruct.Mapper;

import com.techchallenge.techchallenge.core.domain.entity.Cozinheiro;

@Mapper(componentModel = "spring")
public interface CozinheiroEntityMapper {
    CozinheiroEntity toEntity(Cozinheiro cozinheiro);

    Cozinheiro fromEntity(CozinheiroEntity destination);
}
