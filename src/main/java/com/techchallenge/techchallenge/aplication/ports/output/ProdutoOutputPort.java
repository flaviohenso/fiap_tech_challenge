package com.techchallenge.techchallenge.aplication.ports.output;

import com.techchallenge.techchallenge.core.entities.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoOutputPort {
    public List<Produto> getAll();

    public Produto create(Produto pagamento);

    public Produto updateProduto(Produto produto);

    public Boolean deleteProduto(UUID id);
}
