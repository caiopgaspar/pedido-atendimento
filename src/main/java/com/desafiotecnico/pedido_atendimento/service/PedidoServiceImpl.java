package com.desafiotecnico.pedido_atendimento.service;

import com.desafiotecnico.pedido_atendimento.domain.entities.Cliente;
import com.desafiotecnico.pedido_atendimento.domain.entities.Produto;
import com.desafiotecnico.pedido_atendimento.domain.enums.PedidoStatusEnum;
import com.desafiotecnico.pedido_atendimento.dto.request.ItemRequest;
import com.desafiotecnico.pedido_atendimento.dto.request.UpdatePedidoRequest;
import com.desafiotecnico.pedido_atendimento.repository.ClienteRepository;
import com.desafiotecnico.pedido_atendimento.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import com.desafiotecnico.pedido_atendimento.domain.entities.Pedido;
import com.desafiotecnico.pedido_atendimento.dto.request.CreatePedidoRequest;
import com.desafiotecnico.pedido_atendimento.dto.response.PedidoResponse;
import com.desafiotecnico.pedido_atendimento.integration.mapper.PedidoMapper;
import com.desafiotecnico.pedido_atendimento.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoMapper pedidoMapper;
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    
    
    @Override
    public PedidoResponse createPedido(CreatePedidoRequest request) {

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com ID: " + request.getClienteId()));

        List<Produto> produtos = new ArrayList<>();
        for (ItemRequest item : request.getItens()) {
            Produto produto = produtoRepository.findById(item.getProdutoId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com ID: " + item.getProdutoId()));
            produtos.add(produto);
        }

        Pedido pedido = pedidoMapper.toPedidoEntity(request, cliente, produtos);

        Pedido savedPedido = pedidoRepository.save(pedido);


        return pedidoMapper.toPedidoResponse(savedPedido);

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
