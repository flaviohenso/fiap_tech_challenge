package com.techchallenge.techchallenge.external.datasource.mongodb;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.techchallenge.techchallenge.core.entities.pedido.PedidoStatus;
import com.techchallenge.techchallenge.pkg.dto.pedido.ComboDto;
import com.techchallenge.techchallenge.pkg.dto.pedido.PedidoDto;
import com.techchallenge.techchallenge.pkg.dto.pedido.ProdutoComboDto;
import com.techchallenge.techchallenge.pkg.interfaces.IPedidoDataSource;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PedidoMongoDbDataSource implements IPedidoDataSource {
    private final MongoClient client;
    private final MongoCollection<Document> collection;

    public PedidoMongoDbDataSource(String connectionString, String database) {
        this.client = MongoClients.create(connectionString);
        MongoDatabase mongoDatabase = client.getDatabase(database);
        this.collection = mongoDatabase.getCollection("pedidos");
    }

    @Override
    public PedidoDto insertPedido(PedidoDto pedido) {
        var id = UUID.randomUUID().toString();
        Document document = convertPedidoToDocument(id, pedido);
        collection.insertOne(document);

        pedido.setId(id);
        return pedido;
    }

    public PedidoDto savePedido(PedidoDto pedido) {

        var id = pedido.getId();
        Document updatedDoc = convertPedidoToDocument(id, pedido);
        Bson filter = Filters.eq("id", pedido.getId());

        collection.replaceOne(filter, updatedDoc);

        return pedido;
    }

    private Document convertPedidoToDocument(String id, PedidoDto pedido) {
        System.out.println(id);
        return new Document()
                .append("id", id)
                .append("status", pedido.getStatus().toString())
                .append("clientId", pedido.getClientId())
                .append("combos", pedido.getCombos().stream().map(this::convertComboToDocument).toList())
                .append("createdAt", pedido.getCreatedAt().toString())
                .append("updatedAt", pedido.getUpdatedAt().toString());
    }

    private Document convertComboToDocument(ComboDto combo) {
        return new Document()
                .append("lanche", convertProdutoComboToDocument(combo.getLanche()))
                .append("acompanhamento", convertProdutoComboToDocument(combo.getAcompanhamento()))
                .append("bebida", convertProdutoComboToDocument(combo.getBebida()))
                .append("sobremesa", convertProdutoComboToDocument(combo.getSobremesa()));
    }

    private Document convertProdutoComboToDocument(ProdutoComboDto produto) {
        return new Document()
                .append("idProduto", produto.getIdProduto())
                .append("quantity", produto.getQuantity())
                .append("price", produto.getPrice().toString());
    }

    public PedidoDto getPedidoById(String id) {
        Bson filter = Filters.eq("id", id);
        Document doc = collection.find(filter).first();

        if (doc != null) {
            return convertDocumentToPedido(doc);
        } else {
            return null;
        }
    }

    @Override
    public List<PedidoDto> findAll() {
        List<PedidoDto> pedidos = new ArrayList<>();
        FindIterable<Document> docs = collection.find();
        for (Document doc : docs) {
            pedidos.add(convertDocumentToPedido(doc));
        }
        return pedidos;
    }

    private PedidoDto convertDocumentToPedido(Document doc) {
        String id = doc.getString("id");
        PedidoStatus status = PedidoStatus.valueOf(doc.getString("status"));
        String clientId = doc.getString("clientId");
        List<Document> comboDocs = (List<Document>) doc.get("combos");
        List<ComboDto> combos = new ArrayList<>();
        for (Document comboDoc : comboDocs) {
            combos.add(convertDocumentToCombo(comboDoc));
        }
        OffsetDateTime createdAt = OffsetDateTime.parse(doc.getString("createdAt"), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        OffsetDateTime updatedAt = OffsetDateTime.parse(doc.getString("updatedAt"), DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        return new PedidoDto(id, status, clientId, combos, createdAt, updatedAt);
    }

    private ComboDto convertDocumentToCombo(Document doc) {
        ProdutoComboDto lanche = convertDocumentToProdutoCombo((Document) doc.get("lanche"));
        ProdutoComboDto acompanhamento = convertDocumentToProdutoCombo((Document) doc.get("acompanhamento"));
        ProdutoComboDto bebida = convertDocumentToProdutoCombo((Document) doc.get("bebida"));
        ProdutoComboDto sobremesa = convertDocumentToProdutoCombo((Document) doc.get("sobremesa"));

        return new ComboDto(lanche, acompanhamento, bebida, sobremesa);
    }

    private ProdutoComboDto convertDocumentToProdutoCombo(Document doc) {
        String idProduto = doc.getString("idProduto");
        Integer quantity = doc.getInteger("quantity");
        BigDecimal price = new BigDecimal(doc.getString("price"));

        return new ProdutoComboDto(idProduto, quantity, price);
    }
}
