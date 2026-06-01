package com.desafiotecnico.pedido_atendimento.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
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
