package com.techchallenge.techchallenge.infrastructure.input.adapter;

import org.springdoc.core.annotations.RouterOperation;
import org.springframework.http.ResponseEntity;
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
   @RouterOperation(beanClass = PagamentoAdapter.class, beanMethod = "pagar")
    @PostMapping
    public ResponseEntity<PagamentoResponseDto> pagar(@RequestBody PagamentoRequestDto pagamentoRequestDto) {
        //converte o pagamentoRequestDto para Pagamento
        Pagamento pagamento = pagamentoUseCase.create(pagamentoRequestDto);
        //chamar o serviço de pagamento
        pagamento = pagamentoUseCase.pagar(pagamento);
        //persiste o pagamento e retorna um pagamentoResponseDto
        pagamento = pagamentoUseCase.persistirPagamento(pagamento);
        //gera resposta        
        return ResponseEntity.ok(new PagamentoResponseDto(null, null, null, null, null, null));
    }
}
