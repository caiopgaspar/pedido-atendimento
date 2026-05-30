package com.desafiotecnico.pedido_atendimento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafiotecnico.pedido_atendimento.domain.entities.Pedido;
import com.desafiotecnico.pedido_atendimento.domain.enums.PedidoStatusEnum;
import com.desafiotecnico.pedido_atendimento.dto.request.CreatePedidoRequest;
import com.desafiotecnico.pedido_atendimento.dto.request.UpdatePedidoRequest;
import com.desafiotecnico.pedido_atendimento.dto.response.PedidoResponse;
import com.desafiotecnico.pedido_atendimento.integration.mapper.PedidoMapper;
import com.desafiotecnico.pedido_atendimento.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoMapper pedidoMapper;
    private final PedidoRepository pedidoRepository;
    
    
    @Override    
    public PedidoResponse createPedido(CreatePedidoRequest request) {

        Pedido pedido = pedidoMapper.toEntity(request);

        Pedido savedPedido = pedidoRepository.save(pedido);

        PedidoResponse response = pedidoMapper.toResponse(savedPedido);

        return response;
    }


    @Override
    public PedidoResponse findPedidoById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PedidoResponse> findPedidoByFilters(String clienteId, PedidoStatusEnum status) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PedidoResponse updatePedido(String id, UpdatePedidoRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
    

    @Override
    public void deletePedido(String id) {
        // TODO Auto-generated method stub
        
    }
    

}
