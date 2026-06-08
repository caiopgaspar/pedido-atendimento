package com.desafiotecnico.pedido_atendimento.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @OneToOne
    public Cliente cliente;

    @NotNull
    @Column
    public String cep;

    @NotNull
    public String logradouro;

    public String complemento;

    @NotNull
    public String numero;

    @NotNull
    public String bairro;

    @NotNull
    public String cidade;

    @NotNull
    public String uf;

}
