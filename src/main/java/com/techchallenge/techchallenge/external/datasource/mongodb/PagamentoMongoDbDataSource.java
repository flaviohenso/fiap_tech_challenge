package com.techchallenge.techchallenge.external.datasource.mongodb;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.techchallenge.techchallenge.core.entities.pagamento.StatusPagamento;
import com.techchallenge.techchallenge.pkg.dto.PagamentoDto;
import com.techchallenge.techchallenge.pkg.interfaces.IPagamentoDataSource;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PagamentoMongoDbDataSource implements IPagamentoDataSource {
    private final MongoClient client;
    private final MongoCollection<Document> collection;

    public PagamentoMongoDbDataSource(String connectionString, String database) {
        this.client = MongoClients.create(connectionString);
        MongoDatabase mongoDatabase = client.getDatabase(database);
        this.collection = mongoDatabase.getCollection("pagamentos");
    }

    @Override
    public PagamentoDto insertPagamento(PagamentoDto pagamento) {
        var id = UUID.randomUUID().toString();
        Document document = convertPagamentoToDocument(id, pagamento);
        collection.insertOne(document);

        pagamento.setId(id);
        return pagamento;
    }

    @Override
    public PagamentoDto firstPagamentoByPedidoIdSortByUpdatedAtDesc(String pedidoId) {
        Bson filter = Filters.eq("pedido_id", pedidoId);
        FindIterable<Document> docs = collection.find(filter).sort(Sorts.descending("updated_at"));
        List<PagamentoDto> pagamentos = new ArrayList<>();
        for (Document doc : docs) {
            pagamentos.add(convertDocumentToPagamento(doc));
        }
        return pagamentos.isEmpty() ? null : pagamentos.getFirst();
    }

    @Override
    public PagamentoDto firstPagamentoByExternalIdSortByUpdatedAtDesc(String externalId) {
        Bson filter = Filters.eq("external_id", externalId);
        FindIterable<Document> docs = collection.find(filter).sort(Sorts.descending("updated_at"));
        List<PagamentoDto> pagamentos = new ArrayList<>();
        for (Document doc : docs) {
            pagamentos.add(convertDocumentToPagamento(doc));
        }
        return pagamentos.isEmpty() ? null : pagamentos.getFirst();
    }

    @Override
    public PagamentoDto updatePagamento(PagamentoDto pagamento) {
        var id = pagamento.getId();
        Document updatedDoc = convertPagamentoToDocument(id, pagamento);
        Bson filter = Filters.eq("id", pagamento.getId());
        collection.replaceOne(filter, updatedDoc);
        return pagamento;
    }

    private Document convertPagamentoToDocument(String id, PagamentoDto pagamento) {
        return new Document()
                .append("id", id)
                .append("external_id", pagamento.getExternalId())
                .append("pedido_id", pagamento.getPedidoId())
                .append("valor", pagamento.getValor().toString())
                .append("status", pagamento.getStatus())
                .append("pagamento_confirmado_at", Optional.ofNullable(pagamento.getPagamentoConfirmadoAt())
                        .map(String::valueOf)
                        .orElse(null)
                )
                .append("created_at", pagamento.getCreatedAt().toString())
                .append("updated_at", pagamento.getUpdatedAt().toString());
    }

    private PagamentoDto convertDocumentToPagamento(Document doc) {
        OffsetDateTime createdAt = OffsetDateTime.parse(doc.getString("created_at"), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        OffsetDateTime updatedAt = OffsetDateTime.parse(doc.getString("updated_at"), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        OffsetDateTime pagamentoConfirmadoAt = Optional.ofNullable(doc.getString("pagamento_confirmado_at"))
                .map(string -> OffsetDateTime.parse(string, DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                .orElse(null);

        return new PagamentoDto(
                doc.getString("id"),
                doc.getString("external_id"),
                doc.getString("pedido_id"),
                new BigDecimal(doc.getString("valor")),
                StatusPagamento.valueOf(doc.getString("status")),
                pagamentoConfirmadoAt,
                createdAt,
                updatedAt
        );
    }
}
