package com.desafiotecnico.pedido_atendimento.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import com.desafiotecnico.pedido_atendimento.domain.entities.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponse {

    private String id;

    private String clienteId;
    
    private String status;
    
    private List<ItemResponse> itens;

    private BigDecimal total;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;

}
