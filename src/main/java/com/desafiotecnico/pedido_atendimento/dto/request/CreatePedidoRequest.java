package com.desafiotecnico.pedido_atendimento.dto.request;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import com.desafiotecnico.pedido_atendimento.domain.enums.PedidoStatusEnum;

public class CreatePedidoRequest {

    @NotBlank(message = "O ID do cliente é obrigatório")
    private String clienteId;
    
    private PedidoStatusEnum status = PedidoStatusEnum.CRIADO;

    @NotNull(message = "O pedido deve conter itens")
    @Size(min = 1, message = "O pedido deve conter pelo menos um item")
    @Valid
    private List<ItemRequest> itens;

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class ItemRequest {

    @NotBlank
    private String produtoId;

    @NotNull
    @Positive
    private Integer quantidade;

    @NotNull
    @DecimalMin(value = "0.01")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal precoUnitario;
    
}
