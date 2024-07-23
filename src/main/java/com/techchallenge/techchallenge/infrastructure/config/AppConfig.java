package com.techchallenge.techchallenge.infrastructure.config;

import com.techchallenge.techchallenge.aplication.ports.input.ClienteInputPort;
import com.techchallenge.techchallenge.aplication.ports.input.PagamentoInputPort;
import com.techchallenge.techchallenge.aplication.ports.input.ProdutoInputPort;
import com.techchallenge.techchallenge.aplication.ports.output.ClienteOutputPort;
import com.techchallenge.techchallenge.aplication.ports.output.PagamentoOutputPort;
import com.techchallenge.techchallenge.aplication.ports.output.ProdutoOutputPort;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.mappers.ClienteEntityMapper;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.mapper.PagamentoEntityMapper;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.produto.mapper.ProdutoEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final ClienteOutputPort clienteMongoAdapter;
    private final ClienteEntityMapper clienteEntityMapper;

    private final PagamentoOutputPort pagamentoMongoAdapter;
    private final PagamentoEntityMapper pagamentoEntityMapper;

    private final ProdutoOutputPort produtoMongoAdapter;
    private final ProdutoEntityMapper produtoEntityMapper;

    public AppConfig(
            ClienteEntityMapper clienteEntityMapper,
            PagamentoEntityMapper pagamentoEntityMapper,
            ProdutoEntityMapper produtoEntityMapper,
            ClienteOutputPort clienteMongoAdapter,
            PagamentoOutputPort pagamentoMongoAdapter,
            ProdutoOutputPort produtoMongoAdapter) {

        this.clienteEntityMapper = clienteEntityMapper;
        this.clienteMongoAdapter = clienteMongoAdapter;

        this.pagamentoEntityMapper = pagamentoEntityMapper;
        this.pagamentoMongoAdapter = pagamentoMongoAdapter;

        this.produtoEntityMapper = produtoEntityMapper;
        this.produtoMongoAdapter = produtoMongoAdapter;
    }

    @Bean
    public ClienteInputPort clienteInputPort() {
        return new ClienteInputPort(this.clienteMongoAdapter);
    }

    @Bean
    public PagamentoInputPort pagamentoInputPort() {
        return new PagamentoInputPort(this.pagamentoMongoAdapter);
    }

    @Bean
    public ProdutoInputPort produtoInputPort() {
        return new ProdutoInputPort(this.produtoMongoAdapter);
    }
}
