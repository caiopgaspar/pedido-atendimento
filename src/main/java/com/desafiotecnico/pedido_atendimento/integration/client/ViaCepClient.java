package com.desafiotecnico.pedido_atendimento.integration.client;

import com.desafiotecnico.pedido_atendimento.dto.response.ViaCepResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ViaCepClient {

    private final RestTemplate restTemplate;


    public ViaCepResponse findEnderecoByCep(String cep){

        String url = "https://viacep.com.br/ws/" + cep + "/json";

        return restTemplate.getForObject(url, ViaCepResponse.class);

    }



}
