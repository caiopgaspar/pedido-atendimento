package com.desafiotecnico.pedido_atendimento.integration.mapper;

import com.desafiotecnico.pedido_atendimento.domain.entities.Cliente;
import com.desafiotecnico.pedido_atendimento.domain.entities.Produto;
import com.desafiotecnico.pedido_atendimento.repository.ProdutoRepository;
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

    private final ProdutoRepository produtoRepository;

    public Pedido toPedidoEntity(CreatePedidoRequest request) {

        Pedido pedido = new Pedido();

        pedido.setClienteId(request.getClienteId());

        List<ItemPedido> itensPedido = toItensList(request.getItens(), pedido);
        pedido.setItensPedido(itensPedido);

        pedido.setTotal(calcularTotal(pedido));

        //Setar o Created aqui ou com anotação na entidade?
        pedido.setCreatedAt(LocalDateTime.now());


        return pedido;
    }

    private List<ItemPedido> toItensList (List<ItemRequest> requests, Pedido pedido) {
        List<ItemPedido> itens = new ArrayList<>();
        for (ItemRequest request : requests) {
            itens.add(toItemPedidoEntity(request, pedido));
        }
        return itens;
    }

    private ItemPedido toItemPedidoEntity (ItemRequest request, Pedido pedido) {

//        Produto produto = produtoRepository.findById(request.getProdutoId()).orElseThrow();

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPedido(pedido);
//        itemPedido.setPedidoId(request.getPedidoId());
//        itemPedido.setProduto(produto);
        itemPedido.setProdutoId(request.getProdutoId());
        itemPedido.setQuantidade(request.getQuantidade());
//        itemPedido.setPrecoUnitario(produto.getPrecoUnitario());
        itemPedido.setPrecoUnitario(request.getPrecoUnitario());

        return itemPedido;
    }

//    private ProdutoResponse toProdutoResponse (Produto produto) {
//
//        return ProdutoResponse.builder()
//                .codigoProduto(produto.getCodigoProduto())
//                .nome(produto.getNome())
//                .descricao(produto.getDescricao())
//                .precoUnitario(produto.getPrecoUnitario())
//                .build();
//    }

    public PedidoResponse toPedidoResponse (Pedido pedido) {
        return PedidoResponse.builder()
//                .pedidoCodigo(pedido.getPedidoCodigo())
//                .clienteNome(pedido.getCliente().getNome())
                .itens(pedido.getItensPedido())
                .total(pedido.getTotal())
                .createdAt(pedido.getCreatedAt())
                .build();
    }
//
//    private ItemResponse toItemResponse(ItemPedido itemPedido) {
//        return null;
//    }

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


