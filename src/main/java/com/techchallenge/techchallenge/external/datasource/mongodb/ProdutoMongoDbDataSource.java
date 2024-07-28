package com.techchallenge.techchallenge.external.datasource.mongodb;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.techchallenge.techchallenge.core.entities.produto.Categoria;
import com.techchallenge.techchallenge.pkg.dto.produto.ProdutoDto;
import com.techchallenge.techchallenge.pkg.interfaces.IProdutoDataSource;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProdutoMongoDbDataSource implements IProdutoDataSource {
    private final MongoClient client;
    private final MongoCollection<Document> collection;

    public ProdutoMongoDbDataSource(String connectionString, String database) {
        this.client = MongoClients.create(connectionString);
        MongoDatabase mongoDatabase = client.getDatabase(database);
        this.collection = mongoDatabase.getCollection("produtos");
    }

    @Override
    public ProdutoDto insertProduto(ProdutoDto produto) {
        var id = UUID.randomUUID().toString();
        Document document = convertProdutoToDocument(id, produto);
        collection.insertOne(document);

        produto.setId(id);
        return produto;
    }

    @Override
    public void deleteById(String id) {
        Bson filter = Filters.eq("id", id);
        collection.deleteOne(filter);
    }

    @Override
    public ProdutoDto getProdutoById(String id) {
        Bson filter = Filters.eq("id", id);
        Document doc = collection.find(filter).first();

        if (doc != null) {
            return convertDocumentToProduto(doc);
        } else {
            return null;
        }
    }

    @Override
    public ProdutoDto updateProduto(ProdutoDto produto) {
        var id = produto.getId();
        Document updatedDoc = convertProdutoToDocument(id, produto);
        Bson filter = Filters.eq("id", produto.getId());

        collection.replaceOne(filter, updatedDoc);

        return produto;
    }

    private Document convertProdutoToDocument(String id, ProdutoDto produto) {
        return new Document()
                .append("id", id)
                .append("nome", produto.getNome())
                .append("descricao", produto.getDescricao())
                .append("preco", produto.getPreco().toString())
                .append("categoria", produto.getCategoria())
                .append("imagem", produto.getImagem())
                .append("createdAt", produto.getCreatedAt().toString())
                .append("updatedAt", produto.getUpdatedAt().toString());
    }

    @Override
    public List<ProdutoDto> findAll(Categoria categoria) {
        Bson filter = categoria == null ? new Document() : Filters.eq("categoria", categoria);
        List<ProdutoDto> produtos = new ArrayList<>();
        FindIterable<Document> docs = collection.find(filter);
        for (Document doc : docs) {
            produtos.add(convertDocumentToProduto(doc));
        }
        return produtos;
    }

    private ProdutoDto convertDocumentToProduto(Document doc) {
        OffsetDateTime createdAt = OffsetDateTime.parse(doc.getString("createdAt"), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        OffsetDateTime updatedAt = OffsetDateTime.parse(doc.getString("updatedAt"), DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        return new ProdutoDto(
                doc.getString("id"),
                doc.getString("nome"),
                new BigDecimal(doc.getString("preco")),
                doc.getString("descricao"),
                doc.getString("imagem"),
                Categoria.valueOf(doc.getString("categoria")),
                createdAt,
                updatedAt
        );
    }
}
