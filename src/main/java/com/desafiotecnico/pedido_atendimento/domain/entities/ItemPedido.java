package com.desafiotecnico.pedido_atendimento.domain.entities;

import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
@Table(name = "itempedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "produtoId", referencedColumnName = "id")
    private Produto produto;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pedidoId", referencedColumnName = "id")
    private Pedido pedido;

    @NotNull
    @Positive
    private Integer quantidade;

    @NotNull
    private BigDecimal precoUnitario;


//    public void validarQuantidade() {
//        if (quantidade == null || quantidade <= 0) {
//            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
//        }
//    }

}
