package com.desafiotecnico.pedido_atendimento.service;

import com.desafiotecnico.pedido_atendimento.domain.entities.Cliente;
import com.desafiotecnico.pedido_atendimento.domain.entities.Endereco;
import com.desafiotecnico.pedido_atendimento.dto.request.CreateClienteRequest;
import com.desafiotecnico.pedido_atendimento.dto.response.ClienteResponse;
import com.desafiotecnico.pedido_atendimento.dto.response.EnderecoResponse;
import com.desafiotecnico.pedido_atendimento.dto.response.ViaCepResponse;
import com.desafiotecnico.pedido_atendimento.integration.client.ViaCepClient;
import com.desafiotecnico.pedido_atendimento.integration.mapper.ClienteMapper;
import com.desafiotecnico.pedido_atendimento.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ViaCepClient viaCepClient;
    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse createCliente(CreateClienteRequest request) {

        String cep = request.getEndereco().getCep();
        ViaCepResponse viaCepResponse = viaCepClient.findEnderecoByCep(cep);
        Endereco endereco = clienteMapper.toEnderecoEntity(viaCepResponse, request.getEndereco());

        Cliente cliente = clienteMapper.toClienteEntity(request, endereco);

        Cliente savedCliente = clienteRepository.save(cliente);


        return clienteMapper.toClienteResponse(savedCliente);

    }

}
