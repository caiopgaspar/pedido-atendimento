package com.desafiotecnico.pedido_atendimento.integration.mapper;

import com.desafiotecnico.pedido_atendimento.domain.entities.Cliente;
import com.desafiotecnico.pedido_atendimento.domain.entities.Endereco;
import com.desafiotecnico.pedido_atendimento.dto.request.CreateClienteRequest;
import com.desafiotecnico.pedido_atendimento.dto.request.EnderecoRequest;
import com.desafiotecnico.pedido_atendimento.dto.response.ClienteResponse;
import com.desafiotecnico.pedido_atendimento.dto.response.EnderecoResponse;
import com.desafiotecnico.pedido_atendimento.dto.response.ViaCepResponse;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toClienteEntity(CreateClienteRequest request, Endereco endereco) {

        Cliente cliente = new Cliente();
        cliente.setNome(request.getNome());
        cliente.setCpf(request.getCpf());
        cliente.setEmail(request.getEmail());
        cliente.setEndereco(endereco);

        return cliente;

    }


    public Endereco toEnderecoEntity(ViaCepResponse response, EnderecoRequest request){

        Endereco endereco = new Endereco();
        endereco.setCep(response.getCep());
        endereco.setLogradouro(response.getLogradouro());
        endereco.setBairro(response.getBairro());
        endereco.setCidade(response.getLocalidade());
        endereco.setUf(response.getUf());

        endereco.setNumero(request.getNumero());
        endereco.setComplemento(request.getComplemento());

        return endereco;

    }


    public EnderecoResponse toEnderecoResponse(Endereco endereco) {

        return EnderecoResponse.builder()
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .uf(endereco.getUf())
                .build();

    }


    public ClienteResponse toClienteResponse(Cliente cliente) {

        return ClienteResponse.builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .email(cliente.getEmail())
                .endereco(toEnderecoResponse(cliente.getEndereco()))
                .build();

    }
}
