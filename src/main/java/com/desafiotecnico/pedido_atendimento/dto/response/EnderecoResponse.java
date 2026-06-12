package com.desafiotecnico.pedido_atendimento.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponse {

    public String cep;

    public String logradouro;

    public String numero;

    public String complemento;

    public String bairro;

    public String cidade;

    public String uf;

}
