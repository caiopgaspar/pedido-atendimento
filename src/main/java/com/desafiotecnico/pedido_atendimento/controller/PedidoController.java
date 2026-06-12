package com.desafiotecnico.pedido_atendimento.controller;

import com.desafiotecnico.pedido_atendimento.dto.request.CreatePedidoRequest;
import com.desafiotecnico.pedido_atendimento.dto.response.PedidoResponse;
import com.desafiotecnico.pedido_atendimento.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponse> createPedido (@RequestBody CreatePedidoRequest request) {

        PedidoResponse response = pedidoService.createPedido(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
