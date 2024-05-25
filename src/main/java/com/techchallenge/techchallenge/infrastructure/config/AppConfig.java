package com.techchallenge.techchallenge.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.techchallenge.techchallenge.aplication.ports.input.ClienteInputPort;
import com.techchallenge.techchallenge.aplication.ports.input.CozinheiroInputPort;
import com.techchallenge.techchallenge.aplication.ports.output.ClienteOutPort;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.ClienteMongoAdapter;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.mappers.ClienteEntityMapper;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.repository.ClienteRepository;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.repository.IClienteRepository;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.repository.MongoClienteRepository;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro.CozinheiroMongoAdapter;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro.mappers.CozinheiroEntityMapper;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro.repository.CozinheiroRepository;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro.repository.ICozinheiroRepository;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cozinheiro.repository.MongoCozinheiroRepository;

@Configuration
public class AppConfig {

    private final ClienteOutPort clienteMongoAdapter;
    private final IClienteRepository clienteRepository;
    private final ClienteEntityMapper clienteEntityMapper;
    private final MongoClienteRepository mongoClienteRepository;

    private final CozinheiroMongoAdapter cozinheiroMongoAdapter;
    private final ICozinheiroRepository cozinheiroRepository;
    private final CozinheiroEntityMapper cozinheiroEntityMapper;
    private final MongoCozinheiroRepository mongoCozinheiroRepository;

    public AppConfig(
        ClienteEntityMapper clienteEntityMapper, MongoClienteRepository mongoClienteRepository, IClienteRepository clienteRepository,
        CozinheiroEntityMapper cozinheiroEntityMapper, MongoCozinheiroRepository mongoCozinheiroRepository, ICozinheiroRepository cozinheiroRepository) {
        this.clienteRepository = clienteRepository;
        this.clienteEntityMapper = clienteEntityMapper;
        this.mongoClienteRepository = mongoClienteRepository;
        this.clienteMongoAdapter = new ClienteMongoAdapter((ClienteRepository) this.clienteRepository);

        this.cozinheiroRepository = cozinheiroRepository;
        this.cozinheiroEntityMapper = cozinheiroEntityMapper;
        this.mongoCozinheiroRepository = mongoCozinheiroRepository;
        this.cozinheiroMongoAdapter = new CozinheiroMongoAdapter((CozinheiroRepository) this.cozinheiroRepository);
    }

    @Bean
    public ClienteInputPort clienteInputPort() {
        return new ClienteInputPort(this.clienteMongoAdapter);
    }

    @Bean
    public CozinheiroInputPort cozinheiroInputPort() {
        return new CozinheiroInputPort(this.cozinheiroMongoAdapter);
    }
}
