package com.techchallenge.techcahllenge.usecases;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.techchallenge.techchallenge.aplication.adapters.usecases.AutenticacaoUseCase;
import com.techchallenge.techchallenge.aplication.adapters.usecases.CampanhaUseCase;
import com.techchallenge.techchallenge.domain.entity.Campanha;
import com.techchallenge.techchallenge.domain.entity.Cliente;

/**
 * CampanhaUseCaseTest
 * Testa se o cliente está autenticado para realizar a campanha.
 */
public class CampanhaUseCaseTest {


    @InjectMocks
    CampanhaUseCase campanhaUseCase;

    @Mock
    AutenticacaoUseCase autenticacaoUseCase;

    @BeforeEach
    void setUp() {
        autenticacaoUseCase = mock(AutenticacaoUseCase.class);
        campanhaUseCase = new CampanhaUseCase(autenticacaoUseCase);
    }

    // verifica se o cliente está autenticado com cpf caso esteja inicia a campanha
    @Test
    public void deveRetornarClienteAutenticadoQuandoInformarCpf() {

        // quando chamar o método autenticarCliente passando um cliente com cpf, então retorne true
        when(autenticacaoUseCase.autenticarCliente(any())).thenReturn(true);

        Cliente cliente = new Cliente();
        cliente.setCpf("12345678900");
        Campanha campanha = campanhaUseCase.iniciarCampanha(cliente);
        assertNotNull(campanha);
    }

    // verifica se o cliente não está autenticado e messe caso não inicia a campanha
    @Test
    public void deveRetornarClienteNaoAutenticadoQuandoNaoInformarCpf() {

        // quando chamar o método autenticarCliente passando um cliente sem cpf, então retorne false
        when(autenticacaoUseCase.autenticarCliente(any())).thenReturn(false);

        Cliente cliente = new Cliente();
        cliente.setCpf(null);
        Campanha campanha = campanhaUseCase.iniciarCampanha(cliente);
        assertNull(campanha);
    }

}
