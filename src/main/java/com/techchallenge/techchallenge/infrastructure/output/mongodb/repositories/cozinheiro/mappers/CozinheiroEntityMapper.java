package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro.mappers;

import org.mapstruct.Mapper;

import com.techchallenge.techchallenge.core.domain.entity.Cozinheiro;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro.entity.CozinheiroEntity;

@Mapper(componentModel = "spring")
public interface CozinheiroEntityMapper {
    CozinheiroEntity toEntity(Cozinheiro cozinheiro);

    Cozinheiro fromEntity(CozinheiroEntity destination);
}
