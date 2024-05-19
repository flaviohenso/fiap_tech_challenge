package com.techchallenge.techchallenge.usecases;

import com.techchallenge.techchallenge.domain.entity.Cliente;
import com.techchallenge.techchallenge.exceptions.CpfAlreadySavedException;
import com.techchallenge.techchallenge.exceptions.NotFoundException;
import com.techchallenge.techchallenge.repositories.cliente.IClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClienteUseCases {

    final private IClienteRepository repository;

    public List<Cliente> findAll(String cpf) {
        if (cpf == null || cpf.isBlank()) return repository.getAll();
        else return repository.getByCPF(cpf);
    }

    public Cliente findById(UUID id) {
        return repository.getById(id).orElseThrow(() -> new NotFoundException("cliente not found"));
    }

    public Cliente create(Cliente cliente) {
        var clientsWithSameCPF = repository.getByCPF(cliente.getCpf());
        if (!clientsWithSameCPF.isEmpty()) throw new CpfAlreadySavedException();

        cliente.setId(UUID.randomUUID());
        return repository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        repository.getById(cliente.getId())
                .orElseThrow(() -> new NotFoundException("cliente not found"));
        return repository.save(cliente);
    }

    public void delete(UUID id) {
        repository.delete(id);
    }
}
