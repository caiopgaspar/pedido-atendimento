package com.desafiotecnico.pedido_atendimento.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import com.desafiotecnico.pedido_atendimento.domain.enums.PedidoStatusEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "pedidocodigo")
    private String pedidoCodigo;

    @OneToOne
    @JoinColumn(name = "clienteId", referencedColumnName = "id")
    private Cliente cliente;
    
    @Column(nullable = false)
    private String status;
    
    @OneToMany
    private List<ItemPedido> itensPedido;

    @Column
    private BigDecimal total;
    
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
