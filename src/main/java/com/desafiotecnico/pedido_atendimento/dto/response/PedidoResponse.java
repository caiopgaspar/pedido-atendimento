package com.desafiotecnico.pedido_atendimento.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import com.desafiotecnico.pedido_atendimento.domain.entities.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponse {

    private String pedidoCodigo;

    private String clienteNome;

    private List<ItemPedido> itens;

    private BigDecimal total;

    private String status;
    
    private LocalDateTime createdAt;

}
