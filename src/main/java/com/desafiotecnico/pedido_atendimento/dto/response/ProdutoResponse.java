package com.desafiotecnico.pedido_atendimento.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {

    public String codigoProduto;

    public String nome;

    public String descricao;

    public BigDecimal precoUnitario;

}
