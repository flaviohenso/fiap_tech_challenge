package com.techchallenge.techchallenge.infrastructure.input.adapter;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techchallenge.techchallenge.aplication.usecases.PagamentoUseCase;
import com.techchallenge.techchallenge.core.domain.entity.Pagamento;
import com.techchallenge.techchallenge.infrastructure.input.dto.pagamento.PagamentoDtoMapper;
import com.techchallenge.techchallenge.infrastructure.input.dto.pagamento.PagamentoRequestDto;
import com.techchallenge.techchallenge.infrastructure.input.dto.pagamento.PagamentoResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/pagamentos")
@AllArgsConstructor
public class PagamentoAdapter {

    private final PagamentoUseCase pagamentoUseCase;
    private final PagamentoDtoMapper mapper;
    /*
     * End point para pagamento
     */
    @Operation(summary = "Realiza um pagamento", description = "Realiza um pagamento e retorna o status do pagamento.")
    @PostMapping
    public ResponseEntity<PagamentoResponseDto> pagar(@RequestBody PagamentoRequestDto pagamentoRequestDto) {
        Pagamento pagamento = pagamentoUseCase.create(mapper.fromDto(pagamentoRequestDto));
        pagamento = pagamentoUseCase.pagar(pagamento);
        pagamento = pagamentoUseCase.persistirPagamento(pagamento);
        return ResponseEntity.ok(pagamentoUseCase.gerarResponse(pagamento));
    }

    @GetMapping()
    public ResponseEntity<List<Pagamento>> getAllPagamentos() {
        return ResponseEntity.ok().body(pagamentoUseCase.findAll());
    }
}
