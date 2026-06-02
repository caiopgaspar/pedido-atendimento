package com.desafiotecnico.pedido_atendimento.dto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {
    
    private String produtoNome;

    private Integer quantidade;

    private BigDecimal precoUnitario;

}
