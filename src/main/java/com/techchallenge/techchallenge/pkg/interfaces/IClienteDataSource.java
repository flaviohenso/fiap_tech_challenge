package com.techchallenge.techchallenge.pkg.interfaces;

import com.techchallenge.techchallenge.pkg.dto.cliente.ClienteDto;

import java.util.List;

public interface IClienteDataSource {
    ClienteDto insertCliente(ClienteDto cliente);

    List<ClienteDto> findByCpf(String cpf);

    void deleteById(String id);

    ClienteDto getById(String id);

    ClienteDto updateCliente(ClienteDto cliente);
}
