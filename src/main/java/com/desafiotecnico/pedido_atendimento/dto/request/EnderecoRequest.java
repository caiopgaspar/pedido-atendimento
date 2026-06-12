package com.desafiotecnico.pedido_atendimento.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequest {

    @NotNull
    public String cep;

    public String logradouro;

    public String complemento;

    @NotNull
    public String numero;

    public String bairro;

    public String cidade;

    public String uf;

}
