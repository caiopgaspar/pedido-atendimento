package com.desafiotecnico.pedido_atendimento.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;


    public String nome;

    @NotNull
    @CPF
    public String cpf;

    @NotNull
    public String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    public Endereco endereco;

}
