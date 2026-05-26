package com.desafiotecnico.pedido_atendimento.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafiotecnico.pedido_atendimento.domain.entities.Pedido;
import com.desafiotecnico.pedido_atendimento.domain.enums.PedidoStatusEnum;

public interface PedidoRepository extends JpaRepository <Pedido, String>{

    @Query("SELECT p FROM Pedido p WHERE" +
            "(:clienteId IS NULL OR p.clieteId = :clienteId) AND " +
            "(:status IS NULL OR p.status = :status)")
    List<Pedido> findByFilters(@Param("clienteId") String clienteId,
                                @Param("status") PedidoStatusEnum status);
    
        

}
