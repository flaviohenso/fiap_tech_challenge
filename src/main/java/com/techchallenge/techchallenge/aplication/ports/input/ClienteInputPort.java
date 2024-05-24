package com.techchallenge.techchallenge.aplication.ports.input;

import java.util.List;
import java.util.UUID;

import com.techchallenge.techchallenge.aplication.ports.output.ClienteOutPort;
import com.techchallenge.techchallenge.aplication.usecases.ClienteUseCase;
import com.techchallenge.techchallenge.core.domain.entity.Cliente;
import com.techchallenge.techchallenge.core.domain.exceptions.CpfAlreadySavedException;
import com.techchallenge.techchallenge.core.domain.exceptions.NotFoundException;
import com.techchallenge.techchallenge.infrastructure.output.mongodb.repositories.cliente.repository.IClienteRepository;

//@service
public class ClienteInputPort implements ClienteUseCase{

    private ClienteOutPort clienteOutPort;
    final private IClienteRepository repository;

    public ClienteInputPort(ClienteOutPort clienteOutPort, IClienteRepository repository) {
        this.clienteOutPort = clienteOutPort;
        this.repository = repository;
    }

    @Override
    public List<Cliente> findAll(String cpf) {
        if (cpf == null || cpf.isBlank()) return repository.getAll();
        else return repository.getByCPF(cpf);
    }

    @Override
    public Cliente findById(UUID id) {
        return repository.getById(id).orElseThrow(() -> new NotFoundException("cliente not found"));
    }

    @Override
    public Cliente create(Cliente cliente) {
        var clientsWithSameCPF = repository.getByCPF(cliente.getCpf());
        if (!clientsWithSameCPF.isEmpty()) throw new CpfAlreadySavedException();

        cliente.setId(UUID.randomUUID());
        return repository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        repository.getById(cliente.getId())
                .orElseThrow(() -> new NotFoundException("cliente not found"));
        return repository.save(cliente);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(id);
    }
    
}
