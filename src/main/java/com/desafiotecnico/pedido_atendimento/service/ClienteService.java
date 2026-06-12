package com.desafiotecnico.pedido_atendimento.service;

import com.desafiotecnico.pedido_atendimento.dto.request.CreateClienteRequest;
import com.desafiotecnico.pedido_atendimento.dto.response.ClienteResponse;

public interface ClienteService {
    ClienteResponse createCliente(CreateClienteRequest request);

}
