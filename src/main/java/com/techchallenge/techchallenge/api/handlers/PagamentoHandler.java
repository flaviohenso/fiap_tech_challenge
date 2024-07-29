package com.techchallenge.techchallenge.api.handlers;

import com.techchallenge.techchallenge.adapters.controller.payment.PagamentoController;
import com.techchallenge.techchallenge.core.entities.pagamento.PagamentoEntity;
import com.techchallenge.techchallenge.core.requests.CallbackPagamentoDto;
import com.techchallenge.techchallenge.core.requests.CriarPagamentoDto;
import com.techchallenge.techchallenge.external.datasource.mongodb.PagamentoMongoDbDataSource;
import com.techchallenge.techchallenge.external.datasource.mongodb.PedidoMongoDbDataSource;
import com.techchallenge.techchallenge.external.webclient.MercadoPagoPaymentProcessorWebClient;
import com.techchallenge.techchallenge.pkg.interfaces.IPagamentoDataSource;
import com.techchallenge.techchallenge.pkg.interfaces.IPaymentProcessorWebClient;
import com.techchallenge.techchallenge.pkg.interfaces.IPedidoDataSource;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/pagamentos")
public class PagamentoHandler {

    private final String mongoConnection;

    private final String mongoDatabase;

    private final String paymentCallbackUrl;

    public PagamentoHandler(
            @Value("${mongo.connection}") String mongoConnection,
            @Value("${mongo.database}") String mongoDatabase,
            @Value("${payment.callback.url}") String paymentCallbackUrl
    ) {
        this.mongoConnection = mongoConnection;
        this.mongoDatabase = mongoDatabase;
        this.paymentCallbackUrl = paymentCallbackUrl;
    }

    @Operation(
            summary = "Cria novo pagamento",
            description = "Cria um novo pagamento na base de dados."
    )

    @PostMapping
    public ResponseEntity<PagamentoEntity> create(@RequestBody CriarPagamentoDto dto) {
        IPagamentoDataSource pagamentoDataSource = new PagamentoMongoDbDataSource(mongoConnection, mongoDatabase);
        IPedidoDataSource pedidoDataSource = new PedidoMongoDbDataSource(mongoConnection, mongoDatabase);
        IPaymentProcessorWebClient webClient = new MercadoPagoPaymentProcessorWebClient(paymentCallbackUrl);
        PagamentoController controller = new PagamentoController(pedidoDataSource, pagamentoDataSource, webClient);

        PagamentoEntity pagamento = controller.criarPagamento(dto);
        return new ResponseEntity<>(pagamento, HttpStatus.CREATED);
    }

    @PostMapping("/callback")
    public ResponseEntity<PagamentoEntity> callback(@RequestBody CallbackPagamentoDto dto) {
        IPagamentoDataSource pagamentoDataSource = new PagamentoMongoDbDataSource(mongoConnection, mongoDatabase);
        IPedidoDataSource pedidoDataSource = new PedidoMongoDbDataSource(mongoConnection, mongoDatabase);
        IPaymentProcessorWebClient webClient = new MercadoPagoPaymentProcessorWebClient(paymentCallbackUrl);
        PagamentoController controller = new PagamentoController(pedidoDataSource, pagamentoDataSource, webClient);

        PagamentoEntity pagamento = controller.pagamentoStatusCallback(dto.getExternalId());
        return new ResponseEntity<>(pagamento, HttpStatus.CREATED);
    }
}
