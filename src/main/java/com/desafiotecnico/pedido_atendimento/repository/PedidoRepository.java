package com.desafiotecnico.pedido_atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desafiotecnico.pedido_atendimento.domain.entities.Pedido;

public interface PedidoRepository extends JpaRepository <Pedido, String>{



}
