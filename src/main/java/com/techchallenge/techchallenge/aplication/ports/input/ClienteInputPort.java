package com.techchallenge.techchallenge.aplication.ports.input;

import java.util.List;
import java.util.UUID;

import com.techchallenge.techchallenge.aplication.ports.output.ClienteOutPort;
import com.techchallenge.techchallenge.aplication.usecases.ClienteUseCase;
import com.techchallenge.techchallenge.core.domain.entity.Cliente;
import com.techchallenge.techchallenge.core.domain.exceptions.CpfAlreadySavedException;
import com.techchallenge.techchallenge.core.domain.exceptions.NotFoundException;

public class ClienteInputPort implements ClienteUseCase{

    private ClienteOutPort clienteOutPort;

    public ClienteInputPort(ClienteOutPort clienteOutPort) {
        this.clienteOutPort = clienteOutPort;
    }

    @Override
    public List<Cliente> findAll(String cpf) {
        if (cpf == null || cpf.isBlank()) return clienteOutPort.getAll();
        else return clienteOutPort.getByCPF(cpf);
    }

    @Override
    public Cliente findById(UUID id) {
        return clienteOutPort.getById(id).orElseThrow(() -> new NotFoundException("cliente not found"));
    }

    @Override
    public Cliente create(Cliente cliente) {
        var clientsWithSameCPF = clienteOutPort.getByCPF(cliente.getCpf());
        if (!clientsWithSameCPF.isEmpty()) throw new CpfAlreadySavedException();

        cliente.setId(UUID.randomUUID());
        return clienteOutPort.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        clienteOutPort.getById(cliente.getId())
                .orElseThrow(() -> new NotFoundException("cliente not found"));
        return clienteOutPort.save(cliente);
    }

    @Override
    public void delete(UUID id) {
        clienteOutPort.delete(id);
    }
    
}
