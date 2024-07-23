package com.techchallenge.techchallenge.aplication.ports.input;

import com.techchallenge.techchallenge.aplication.ports.output.ClienteOutputPort;
import com.techchallenge.techchallenge.core.entities.Cliente;
import com.techchallenge.techchallenge.core.exceptions.CpfAlreadySavedException;
import com.techchallenge.techchallenge.core.exceptions.NotFoundException;
import com.techchallenge.techchallenge.core.usecases.ClienteUseCase;

import java.util.List;
import java.util.UUID;

public class ClienteInputPort implements ClienteUseCase {

    private ClienteOutputPort clienteOutPort;

    public ClienteInputPort(ClienteOutputPort clienteOutPort) {
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
