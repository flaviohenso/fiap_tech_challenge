package com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.pagamento.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.techchallenge.techchallenge.core.domain.vo.StatusPagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "pagamentos")
public class PagamentoEntity {
    @Id
    private UUID id;
    private String numeroPedido;
    private BigDecimal valor;
    private String observacao;
    private Date dataPagamento;
    private String idCliente;
    private String canal;
    private StatusPagamento status;
}
