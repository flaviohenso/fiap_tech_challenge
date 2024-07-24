package com.techchallenge.techchallenge.pkg.interfaces;

import com.techchallenge.techchallenge.pkg.dto.cliente.ClienteDto;

import java.util.List;

public interface IClienteDataSource {
    ClienteDto insertCliente(ClienteDto cliente);

    List<ClienteDto> findByCpf(String cpf);
}
