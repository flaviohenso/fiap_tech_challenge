package com.techchallenge.techchallenge.aplication.ports.output;

import java.util.List;
import java.util.UUID;

import com.techchallenge.techchallenge.core.domain.entity.Produto;

public interface ProdutoOutputPort {
    public List<Produto> getAll();
    public Produto create(Produto pagamento);  
    public Produto updateProduto(Produto produto);
    public Boolean deleteProduto(UUID id);
}
