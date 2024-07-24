package com.techchallenge.techchallenge.infrastructure.input.adapter;

import com.techchallenge.techchallenge.core.entities.Pagamento;
import com.techchallenge.techchallenge.core.usecases.PagamentoUseCase;
import com.techchallenge.techchallenge.infrastructure.input.dto.pagamento.PagamentoDtoMapper;
import com.techchallenge.techchallenge.infrastructure.input.dto.pagamento.PagamentoRequestDto;
import com.techchallenge.techchallenge.infrastructure.input.dto.pagamento.PagamentoResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
