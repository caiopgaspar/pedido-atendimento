package com.desafiotecnico.pedido_atendimento.integration.mapper;

import com.desafiotecnico.pedido_atendimento.domain.entities.Cliente;
import com.desafiotecnico.pedido_atendimento.domain.entities.Produto;
import com.desafiotecnico.pedido_atendimento.domain.enums.PedidoStatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.desafiotecnico.pedido_atendimento.domain.entities.ItemPedido;
import com.desafiotecnico.pedido_atendimento.domain.entities.Pedido;
import com.desafiotecnico.pedido_atendimento.dto.request.CreatePedidoRequest;
import com.desafiotecnico.pedido_atendimento.dto.request.ItemRequest;
import com.desafiotecnico.pedido_atendimento.dto.response.PedidoResponse;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoMapper {

    public Pedido toPedidoEntity(CreatePedidoRequest request, Cliente cliente, List<Produto> produtos) {

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        List<ItemPedido> itensPedido = toItensList(request.getItens(), pedido, produtos);
        pedido.setItensPedido(itensPedido);

        pedido.setTotal(calcularTotal(pedido));

        pedido.setStatus(PedidoStatusEnum.CRIADO);

        pedido.setCreatedAt(LocalDateTime.now());


        return pedido;
    }


    private List<ItemPedido> toItensList (List<ItemRequest> requests, Pedido pedido, List<Produto> produtos) {

        List<ItemPedido> itens = new ArrayList<>();

        for (int i = 0; i < requests.size(); i++) {
            ItemRequest request = requests.get(i);
            Produto produto = produtos.get(i);
            itens.add(toItemPedidoEntity(request, pedido, produto));
        }


        return itens;
    }


    private ItemPedido toItemPedidoEntity (ItemRequest request, Pedido pedido, Produto produto) {

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setPedido(pedido);

        itemPedido.setQuantidade(request.getQuantidade());

        itemPedido.setProduto(produto);

        itemPedido.setPrecoUnitario(produto.getPrecoUnitario());


        return itemPedido;
    }


    public PedidoResponse toPedidoResponse (Pedido pedido) {

        return PedidoResponse.builder()
                .pedidoCodigo(pedido.getPedidoCodigo())
                .clienteNome(pedido.getCliente().getNome())
                .itens(pedido.getItensPedido())
                .total(pedido.getTotal())
                .status(pedido.getStatus().toString())
                .createdAt(pedido.getCreatedAt())
                .build();

    }


    private BigDecimal calcularTotal( Pedido pedido) {

        BigDecimal soma = BigDecimal.ZERO;

        List<ItemPedido> itensPedido = pedido.getItensPedido();

        for (ItemPedido itemPedido : itensPedido) {
            BigDecimal preco = itemPedido.getPrecoUnitario();
            int quantidade = itemPedido.getQuantidade();

            BigDecimal totalItem = preco.multiply(BigDecimal.valueOf(quantidade));
            soma = soma.add(totalItem);
        }

        return soma;
    }


}
