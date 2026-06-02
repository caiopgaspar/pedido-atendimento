package com.desafiotecnico.pedido_atendimento.dto.request;

import java.math.BigDecimal;

import com.desafiotecnico.pedido_atendimento.domain.entities.Produto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    @NotBlank
    private String produtoId;

    @NotNull
    @Positive
    private Integer quantidade;

    @NotNull
    @DecimalMin(value = "0.01")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal precoUnitario;
    
}
