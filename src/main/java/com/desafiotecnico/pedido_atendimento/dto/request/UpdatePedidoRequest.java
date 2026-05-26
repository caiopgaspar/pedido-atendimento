package com.desafiotecnico.pedido_atendimento.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePedidoRequest {
    
    @NotBlank(message = "clienteId é obrigatório")
    private String clienteId;
    
    @NotNull(message = "itens é obrigatório")
    @Size(min = 1, message = "Pedido deve ter pelo menos um item")
    @Valid
    private List<UpdateItemRequest> itens;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class UpdateItemRequest {
    
    @NotBlank(message = "ID do produto é obrigatório")
    private String produtoId;
    
    @NotNull(message = "Quantidade é obrigatória")
    @Positive(message = "Quantidade deve ser maior que zero")
    private Integer quantidade;
    
    @NotNull(message = "Preço Unitário é obrigatório")
    @DecimalMin(value = "0.01", message = "Preço Unitário deve ser maior que zero")
    @Digits(integer = 10, fraction = 2, message = "Preço Unitário deve ter até 2 casas decimais")
    private BigDecimal precoUnitario;
}