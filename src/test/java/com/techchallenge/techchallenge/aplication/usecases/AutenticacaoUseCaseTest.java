package com.techchallenge.techchallenge.aplication.usecases;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.techchallenge.techchallenge.core.domain.entity.Cliente;

/**
 * AutenticacaoUseCaseTest
 * Teste responsável por validar a autenticação de cliente. Para autenticar o
 * cliente informa o CPF, o cliente também tem a opção
 * de não informar o cpf e isso não impede de realizar o pedido.
 * 
 */
public class AutenticacaoUseCaseTest {

    // método de teste para verificar se o cliente nao informou o cpf
    @Test
    public void deveRetornarClienteNaoAutenticadoQuandoNaoInformarCpf() {
        AutenticacaoUseCase autenticacaoUseCase = new AutenticacaoUseCase();
        Cliente cliente = new Cliente();
        cliente.setCpf(null);
        boolean clienteAutenticado = autenticacaoUseCase.autenticarCliente(cliente);
        assertFalse(clienteAutenticado);
    }

    // método de teste para verificar se o cliente informou o cpf
    @Test
    public void deveRetornarClienteAutenticadoQuandoInformarCpf() {
        AutenticacaoUseCase autenticacaoUseCase = new AutenticacaoUseCase();
        Cliente cliente = new Cliente();
        cliente.setCpf("12345678900");
        boolean clienteAutenticado = autenticacaoUseCase.autenticarCliente(cliente);
        assertTrue(clienteAutenticado);
    }
}
