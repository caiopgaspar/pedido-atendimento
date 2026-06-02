package com.desafiotecnico.pedido_atendimento.repository;

import com.desafiotecnico.pedido_atendimento.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto, String> {


}
