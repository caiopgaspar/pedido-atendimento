package com.desafiotecnico.pedido_atendimento.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    public String codigoProduto;

    public String nome;

    public String descricao;

    public BigDecimal precoUnitario;

}
