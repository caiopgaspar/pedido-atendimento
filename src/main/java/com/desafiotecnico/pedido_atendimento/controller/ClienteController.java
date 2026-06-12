package com.desafiotecnico.pedido_atendimento.controller;

import com.desafiotecnico.pedido_atendimento.dto.request.CreateClienteRequest;
import com.desafiotecnico.pedido_atendimento.dto.response.ClienteResponse;
import com.desafiotecnico.pedido_atendimento.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponse> createCliente (@RequestBody CreateClienteRequest request) {

        ClienteResponse response = clienteService.createCliente(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
