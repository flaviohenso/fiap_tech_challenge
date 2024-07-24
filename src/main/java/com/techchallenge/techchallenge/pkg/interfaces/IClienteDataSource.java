package com.techchallenge.techchallenge.pkg.interfaces;

import com.techchallenge.techchallenge.pkg.dto.cliente.ClienteDto;

public interface IClienteDataSource {
    ClienteDto insertCliente(ClienteDto cliente);
}
