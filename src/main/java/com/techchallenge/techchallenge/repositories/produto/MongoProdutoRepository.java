package com.techchallenge.techchallenge.repositories.produto;

import com.techchallenge.techchallenge.repositories.produto.entities.ProdutoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.UUID;

public interface MongoProdutoRepository extends MongoRepository<ProdutoEntity, UUID> {


}
