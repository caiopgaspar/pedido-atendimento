package com.desafiotecnico.pedido_atendimento.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    public String nome;

    public String cpf;

    public String email;

    public EnderecoResponse endereco;

}
