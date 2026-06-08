package com.desafiotecnico.pedido_atendimento.repository;

import com.desafiotecnico.pedido_atendimento.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, String>{



}
