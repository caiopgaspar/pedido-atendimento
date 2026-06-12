package com.desafiotecnico.pedido_atendimento.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClienteRequest {

    @NotNull
    public String nome;

    @CPF
    public String cpf;

    @NotNull
    @Email
    public String email;

    @NotNull
    public EnderecoRequest endereco;

}
