package com.desafiotecnico.pedido_atendimento.repository;

import com.desafiotecnico.pedido_atendimento.domain.entities.Endereco;
import com.desafiotecnico.pedido_atendimento.dto.response.EnderecoResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository <Endereco, String>{

    EnderecoResponse findByCep(String cep);


}
