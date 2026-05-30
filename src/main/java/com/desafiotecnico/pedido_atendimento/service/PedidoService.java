package com.desafiotecnico.pedido_atendimento.service;

import java.util.List;

import com.desafiotecnico.pedido_atendimento.domain.enums.PedidoStatusEnum;
import com.desafiotecnico.pedido_atendimento.dto.request.CreatePedidoRequest;
import com.desafiotecnico.pedido_atendimento.dto.request.UpdatePedidoRequest;
import com.desafiotecnico.pedido_atendimento.dto.response.PedidoResponse;

public interface PedidoService {

    PedidoResponse createPedido(CreatePedidoRequest request);

    PedidoResponse findPedidoById(String id);

    List<PedidoResponse> findPedidoByFilters(String clienteId, PedidoStatusEnum status);

    PedidoResponse updatePedido(String id, UpdatePedidoRequest request);

    
    void deletePedido(String id);

}
