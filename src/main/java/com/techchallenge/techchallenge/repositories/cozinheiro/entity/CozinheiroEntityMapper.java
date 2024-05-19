package com.techchallenge.techchallenge.repositories.cozinheiro.entity;

import com.techchallenge.techchallenge.domain.entity.Cozinheiro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CozinheiroEntityMapper {
    CozinheiroEntity toEntity(Cozinheiro cozinheiro);

    Cozinheiro fromEntity(CozinheiroEntity destination);
}
