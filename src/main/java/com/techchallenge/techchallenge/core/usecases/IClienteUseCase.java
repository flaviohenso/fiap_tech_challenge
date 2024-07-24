package com.techchallenge.techchallenge.core.usecases;

import com.techchallenge.techchallenge.core.entities.Cliente;

import java.util.List;
import java.util.UUID;

/**
 * ClienteUseCase
 * <p>
 * This interface represents the use case for the Cliente entity.
 */
public interface IClienteUseCase {

    public List<Cliente> findAll(String cpf);

    public Cliente findById(UUID id);

    public Cliente create(Cliente cliente);

    public Cliente update(Cliente cliente);

    public void delete(UUID id);
}
