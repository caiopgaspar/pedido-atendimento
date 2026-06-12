package com.desafiotecnico.pedido_atendimento.domain.entities;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
@Table(name = "itenspedidos")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @OneToOne
    private Produto produto;

    @NotNull
    @ManyToOne
    @JsonIgnore
    private Pedido pedido;

    @NotNull
    @Positive
    private Integer quantidade;

    @NotNull
    private BigDecimal precoUnitario;

}
