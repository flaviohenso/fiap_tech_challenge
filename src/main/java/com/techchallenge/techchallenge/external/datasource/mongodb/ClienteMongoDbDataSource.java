package com.techchallenge.techchallenge.external.datasource.mongodb;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.techchallenge.techchallenge.pkg.dto.cliente.ClienteDto;
import com.techchallenge.techchallenge.pkg.interfaces.IClienteDataSource;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClienteMongoDbDataSource implements IClienteDataSource {
    private final MongoClient client;
    private final MongoCollection<Document> collection;

    public ClienteMongoDbDataSource(String connectionString, String database) {
        this.client = MongoClients.create(connectionString);
        MongoDatabase mongoDatabase = client.getDatabase(database);
        this.collection = mongoDatabase.getCollection("pedidos");
    }

    @Override
    public ClienteDto insertCliente(ClienteDto cliente) {
        var id = UUID.randomUUID().toString();
        Document document = convertClienteToDocument(id, cliente);
        collection.insertOne(document);

        cliente.setId(id);
        return cliente;
    }

    @Override
    public List<ClienteDto> findByCpf(String cpf) {
        Bson filter = cpf == null || cpf.isEmpty() ? new Document() : Filters.eq("cpf", cpf);
        FindIterable<Document> docs = collection.find(filter);
        List<ClienteDto> clientes = new ArrayList<>();
        for (Document doc : docs) {
            clientes.add(convertDocumentToCliente(doc));
        }
        return clientes;
    }

    @Override
    public void deleteById(String id) {
        Bson filter = Filters.eq("id", id);
        collection.deleteOne(filter);
    }

    @Override
    public ClienteDto getById(String id) {
        Bson filter = Filters.eq("id", id);
        Document doc = collection.find(filter).first();

        if (doc != null) {
            return convertDocumentToCliente(doc);
        } else {
            return null;
        }
    }

    @Override
    public ClienteDto updateCliente(ClienteDto cliente) {
        var id = cliente.getId();
        Document updatedDoc = convertClienteToDocument(id, cliente);
        Bson filter = Filters.eq("id", cliente.getId());

        collection.replaceOne(filter, updatedDoc);

        return cliente;
    }

    private Document convertClienteToDocument(String id, ClienteDto cliente) {
        return new Document()
                .append("id", id)
                .append("nome", cliente.getNome())
                .append("cpf", cliente.getCpf())
                .append("telefone", cliente.getTelefone())
                .append("email", cliente.getEmail())
                .append("createdAt", cliente.getCreatedAt().toString())
                .append("updatedAt", cliente.getUpdatedAt().toString());
    }

    public ClienteDto getClienteById(String id) {
        Bson filter = Filters.eq("id", id);
        Document doc = collection.find(filter).first();

        if (doc != null) {
            return convertDocumentToCliente(doc);
        } else {
            return null;
        }
    }

    public List<ClienteDto> findAll() {
        List<ClienteDto> clientes = new ArrayList<>();
        FindIterable<Document> docs = collection.find();
        for (Document doc : docs) {
            clientes.add(convertDocumentToCliente(doc));
        }
        return clientes;
    }

    private ClienteDto convertDocumentToCliente(Document doc) {
        OffsetDateTime createdAt = OffsetDateTime.parse(doc.getString("createdAt"), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        OffsetDateTime updatedAt = OffsetDateTime.parse(doc.getString("updatedAt"), DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        return new ClienteDto(
                doc.getString("id"),
                doc.getString("nome"),
                doc.getString("cpf"),
                doc.getString("email"),
                doc.getString("telefone"),
                createdAt,
                updatedAt
        );
    }
}
