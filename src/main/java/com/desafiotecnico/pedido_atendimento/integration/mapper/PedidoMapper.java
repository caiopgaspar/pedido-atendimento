package com.desafiotecnico.pedido_atendimento.integration.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.desafiotecnico.pedido_atendimento.domain.entities.Item;
import com.desafiotecnico.pedido_atendimento.domain.entities.Pedido;
import com.desafiotecnico.pedido_atendimento.domain.enums.PedidoStatusEnum;
import com.desafiotecnico.pedido_atendimento.dto.request.CreatePedidoRequest;
import com.desafiotecnico.pedido_atendimento.dto.request.ItemRequest;
import com.desafiotecnico.pedido_atendimento.dto.response.ItemResponse;
import com.desafiotecnico.pedido_atendimento.dto.response.PedidoResponse;


// TODO gerar UUID, status CRIADO, calcular total, salvar

@Component
public class PedidoMapper {
    
    public Pedido toEntity(CreatePedidoRequest request) {

        Pedido pedido = new Pedido();
        pedido.setClienteId(request.getClienteId());
        pedido.setStatus(PedidoStatusEnum.CRIADO);

        List<Item> itens = new ArrayList<>();
        if (request.getItens() != null) {
            for (ItemRequest itemRequest : request.getItens()) {
                Item item = toItemEntity(itemRequest);
                itens.add(item);
            }
        }
        pedido.setItens(itens);

        pedido.calcularTotal();

        return pedido;        
    }

    private Item toItemEntity(ItemRequest request) {

        Item item = new Item();
        item.setProdutoId(request.getProdutoId());
        item.setQuantidade(request.getQuantidade());
        item.setPrecoUnitario(request.getPrecoUnitario());

        item.validarQuantidade();

        return item;
    }


    public PedidoResponse toResponse(Pedido pedido) {

        PedidoResponse response = new PedidoResponse();
        response.setId(pedido.getId());
        response.setClienteId(pedido.getClienteId());
        response.setStatus(pedido.getStatus().name());
        response.setTotal(pedido.getTotal());
        response.setCreatedAt(pedido.getCreatedAt());
        response.setUpdatedAt(pedido.getUpdatedAt());

        if (pedido.getItens() != null) {
            /*TODO */
            List<ItemResponse> itensResponse = pedido.getItens()
        }

        return response;        
    }

    private ItemResponse toItemResponse(Item item) {
        
        if (item != null) {
            
            ItemResponse response = new ItemResponse();
            response.setProdutoId(item.getProdutoId());
            response.setQuantidade(item.getQuantidade());
            response.setPrecoUnitario(item.getPrecoUnitario());
            
            /*TODO: total */

            return response;
        
        } else {

            return null;
        }
    }


    


    

}


    /*

    public Pedido toEntity(CreatePedidoRequest request) {
        Pedido pedido = new Pedido();
        pedido.setPedidoId(pedido.getClienteId());
        pedido.setStatus(PedidoStatusEnum.CRIADO);

        List<Item> itens = new ArrayList<>();
        for (ItemRequest ItemRequest : request.getItens()) {
            itens.add(toItemEntity(itemRequest));
        }
        pedido.setItens(itens);

        pedido.calcularTotal();

        return pedido;
    }

    */


