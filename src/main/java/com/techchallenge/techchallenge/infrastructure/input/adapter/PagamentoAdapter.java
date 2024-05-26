package com.techchallenge.techchallenge.infrastructure.input.adapter;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techchallenge.techchallenge.aplication.usecases.PagamentoUseCase;
import com.techchallenge.techchallenge.core.domain.dto.PagamentoRequestDto;
import com.techchallenge.techchallenge.core.domain.dto.PagamentoResponseDto;
import com.techchallenge.techchallenge.core.domain.entity.Pagamento;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/api/pagamentos")
public class PagamentoAdapter {

    private final PagamentoUseCase pagamentoUseCase;

    public PagamentoAdapter(PagamentoUseCase pagamentoUseCase) {
        this.pagamentoUseCase = pagamentoUseCase;
    }

    /*
     * End point para pagamento
     */
    @Operation(summary = "Realiza um pagamento", description = "Realiza um pagamento e retorna o status do pagamento.")
    @PostMapping
    public ResponseEntity<PagamentoResponseDto> pagar(@RequestBody PagamentoRequestDto pagamentoRequestDto) {
        Pagamento pagamento = pagamentoUseCase.create(pagamentoRequestDto);
        pagamento = pagamentoUseCase.pagar(pagamento);
        pagamento = pagamentoUseCase.persistirPagamento(pagamento);
        return ResponseEntity.ok(pagamentoUseCase.gerarResponse(pagamento));
    }

    @GetMapping()
    public ResponseEntity<List<Pagamento>> getAllPagamentos() {
        return ResponseEntity.ok().body(pagamentoUseCase.findAll());
    }
}
