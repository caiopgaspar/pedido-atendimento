package com.desafiotecnico.pedido_atendimento.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.desafiotecnico.pedido_atendimento.domain.entities.Item;
import com.desafiotecnico.pedido_atendimento.domain.enums.PedidoStatusEnum;


public class PedidoResponse {

    private String id;

    private String clienteId;
    
    private String status;
    
    private List<Item> itens;

    private BigDecimal total;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;

}

class ItemResponse {

    private String produtoId;

    private Integer quantidade;

    private BigDecimal precoUnitario;

    private BigDecimal total;

}
