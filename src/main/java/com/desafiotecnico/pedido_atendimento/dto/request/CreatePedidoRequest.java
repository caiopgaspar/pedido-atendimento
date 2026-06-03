package com.desafiotecnico.pedido_atendimento.dto.request;

import java.util.List;

import com.desafiotecnico.pedido_atendimento.domain.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.desafiotecnico.pedido_atendimento.domain.enums.PedidoStatusEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePedidoRequest {

    private String clienteId;

    @NotNull(message = "O pedido deve conter itens")
    @Size(min = 1, message = "O pedido deve conter pelo menos um item")
    @Valid
    private List<ItemRequest> itens;

}