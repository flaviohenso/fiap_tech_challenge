package com.techchallenge.techchallenge.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.techchallenge.techchallenge.aplication.ports.input.ClienteInputPort;
import com.techchallenge.techchallenge.aplication.ports.input.CozinheiroInputPort;
import com.techchallenge.techchallenge.aplication.ports.input.PagamentoInputPort;
import com.techchallenge.techchallenge.aplication.ports.output.ClienteOutputPort;
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
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.PagamentoMongoAdapter;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.mapper.PagamentoEntityMapper;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.repository.IPagamentoRepository;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.repository.MongoPagamentoRepository;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.repository.PagamentoRepository;

@Configuration
public class AppConfig {

    private final ClienteOutputPort clienteMongoAdapter;
    private final IClienteRepository clienteRepository;
    private final ClienteEntityMapper clienteEntityMapper;
    private final MongoClienteRepository mongoClienteRepository;

    private final CozinheiroMongoAdapter cozinheiroMongoAdapter;
    private final ICozinheiroRepository cozinheiroRepository;
    private final CozinheiroEntityMapper cozinheiroEntityMapper;
    private final MongoCozinheiroRepository mongoCozinheiroRepository;

    private final PagamentoMongoAdapter pagamentoMongoAdapter;
    private final IPagamentoRepository pagamentoRepository;
    private final PagamentoEntityMapper pagamentoEntityMapper;
    private final MongoPagamentoRepository mongoPagamentoRepository;

    public AppConfig(
        ClienteEntityMapper clienteEntityMapper, MongoClienteRepository mongoClienteRepository, IClienteRepository clienteRepository,
        CozinheiroEntityMapper cozinheiroEntityMapper, MongoCozinheiroRepository mongoCozinheiroRepository, ICozinheiroRepository cozinheiroRepository,
        PagamentoEntityMapper pagamentoEntityMapper, MongoPagamentoRepository mongoPagamentoRepository, IPagamentoRepository pagamentoRepository) {
        this.clienteRepository = clienteRepository;
        this.clienteEntityMapper = clienteEntityMapper;
        this.mongoClienteRepository = mongoClienteRepository;
        this.clienteMongoAdapter = new ClienteMongoAdapter((ClienteRepository) this.clienteRepository);

        this.cozinheiroRepository = cozinheiroRepository;
        this.cozinheiroEntityMapper = cozinheiroEntityMapper;
        this.mongoCozinheiroRepository = mongoCozinheiroRepository;
        this.cozinheiroMongoAdapter = new CozinheiroMongoAdapter((CozinheiroRepository) this.cozinheiroRepository);

        this.pagamentoRepository = pagamentoRepository;
        this.pagamentoEntityMapper = pagamentoEntityMapper;
        this.mongoPagamentoRepository = mongoPagamentoRepository;
        this.pagamentoMongoAdapter = new PagamentoMongoAdapter((PagamentoRepository) this.pagamentoRepository);
    }

    @Bean
    public ClienteInputPort clienteInputPort() {
        return new ClienteInputPort(this.clienteMongoAdapter);
    }

    @Bean
    public CozinheiroInputPort cozinheiroInputPort() {
        return new CozinheiroInputPort(this.cozinheiroMongoAdapter);
    }

    @Bean
    public PagamentoInputPort pagamentoInputPort() {
        return new PagamentoInputPort(this.pagamentoMongoAdapter);
    }
}
