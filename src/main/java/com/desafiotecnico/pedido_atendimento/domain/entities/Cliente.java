package com.desafiotecnico.pedido_atendimento.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    public String nome;

    @NotNull
    public String email;

    public String endereco;

}
