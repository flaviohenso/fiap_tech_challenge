package com.techchallenge.techchallenge.infrastructure.config;

import com.techchallenge.techchallenge.aplication.ports.input.PagamentoInputPort;
import com.techchallenge.techchallenge.aplication.ports.output.PagamentoOutputPort;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.mapper.PagamentoEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final PagamentoOutputPort pagamentoMongoAdapter;
    private final PagamentoEntityMapper pagamentoEntityMapper;

    public AppConfig(
            PagamentoEntityMapper pagamentoEntityMapper,
            PagamentoOutputPort pagamentoMongoAdapter
    ) {
        this.pagamentoEntityMapper = pagamentoEntityMapper;
        this.pagamentoMongoAdapter = pagamentoMongoAdapter;
    }

    @Bean
    public PagamentoInputPort pagamentoInputPort() {
        return new PagamentoInputPort(this.pagamentoMongoAdapter);
    }
}
