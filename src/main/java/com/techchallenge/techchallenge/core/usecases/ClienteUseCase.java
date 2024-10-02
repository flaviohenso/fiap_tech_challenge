package com.techchallenge.techchallenge.core.usecases;

import com.techchallenge.techchallenge.adapters.gateway.cliente.ClienteGateway;
import com.techchallenge.techchallenge.core.entities.cliente.ClienteEntity;
import com.techchallenge.techchallenge.core.exceptions.ClienteNotFoundException;
import com.techchallenge.techchallenge.core.exceptions.InvalidClienteException;
import com.techchallenge.techchallenge.core.requests.cliente.AtualizarClienteDto;
import com.techchallenge.techchallenge.core.requests.cliente.CriarClienteDto;
import lombok.extern.slf4j.Slf4j;

import java.time.OffsetDateTime;
import java.util.List;

@Slf4j
public class ClienteUseCase {
    private final ClienteGateway clienteGateway;

    public ClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public ClienteEntity criar(CriarClienteDto criarClienteDto) {
        List<ClienteEntity> clientesWithSameCpf = clienteGateway.findByCpf(criarClienteDto.getCpf());

        log.info("clientesWithSameCpf size: {}", clientesWithSameCpf.size());
        if (clientesWithSameCpf != null && !clientesWithSameCpf.isEmpty())
            throw new InvalidClienteException("Cliente com o mesmo CPF já existe");

        var cliente = toClienteEntity(criarClienteDto);
        return clienteGateway.criar(cliente);
    }

    private ClienteEntity toClienteEntity(CriarClienteDto criarClienteDto) {
        OffsetDateTime now = OffsetDateTime.now();
        return new ClienteEntity(
                null,
                criarClienteDto.getNome(),
                criarClienteDto.getCpf(),
                criarClienteDto.getEmail(),
                criarClienteDto.getTelefone(),
                now,
                now
        );
    }

    public List<ClienteEntity> buscarTodos(String cpf) {
        return clienteGateway.findByCpf(cpf);
    }

    public void deletar(String id) {
        clienteGateway.deleteById(id);
    }

    public ClienteEntity buscarPorId(String id) {
        return clienteGateway.buscarPorId(id);
    }

    public ClienteEntity atualizar(String id, AtualizarClienteDto dto) {
        ClienteEntity cliente = clienteGateway.buscarPorId(id);
        if (cliente == null)
            throw new ClienteNotFoundException(id);

        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        cliente.setOffsetDateTime(OffsetDateTime.now());
        return clienteGateway.atualizar(cliente);
    }
}
