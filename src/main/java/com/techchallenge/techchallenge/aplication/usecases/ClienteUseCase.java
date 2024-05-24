package com.techchallenge.techchallenge.aplication.usecases;

import java.util.List;
import java.util.UUID;

import com.techchallenge.techchallenge.core.domain.entity.Cliente;

/**
 * ClienteUseCase
 * 
 * This interface represents the use case for the Cliente entity.
 */
public interface ClienteUseCase {
   
    public List<Cliente> findAll(String cpf);
    public Cliente findById(UUID id);
    public Cliente create(Cliente cliente);
    public Cliente update(Cliente cliente);
    public void delete(UUID id);
}
