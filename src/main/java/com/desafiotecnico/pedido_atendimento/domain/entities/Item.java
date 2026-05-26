package com.desafiotecnico.pedido_atendimento.domain.entities;

import java.math.BigDecimal;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Item {

    private String produtoId;

    private Integer quantidade;

    private BigDecimal precoUnitario;


    public void validarQuantidade() {
        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
    }

}
