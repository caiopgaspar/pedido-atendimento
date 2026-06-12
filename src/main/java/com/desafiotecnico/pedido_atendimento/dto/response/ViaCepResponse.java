package com.desafiotecnico.pedido_atendimento.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViaCepResponse {

    public String cep;

    public String logradouro;

    public String bairro;

    public String localidade;

    public String uf;

}
