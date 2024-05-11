package com.techchallenge.techcahllenge.useCases;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.techchallenge.techcahllenge.domain.entite.Cliente;

/**
 * AutenticacaoUseCaseTest
 * Teste responsável por validar a autenticação de cliente. Para autenticar o cliente informa o CPF, o cliente também tem a opção
 * de não informar o cpf e isso não impede de realizar o pedido.
 * 
 */
public class AutenticacaoUseCaseTest {

//método de teste para verificar se o cliente informou o cpf
    @Test
    public void deveRetornarClienteNaoAutenticadoQuandoNaoInformarCpf() {
        AutenticacaoUseCase autenticacaoUseCase = new AutenticacaoUseCase();
        Cliente cliente = new Cliente();
        cliente.setCpf(null);
        boolean clienteAutenticado = autenticacaoUseCase.autenticarCliente(cliente);
        assertFalse(clienteAutenticado);
    }    
}
