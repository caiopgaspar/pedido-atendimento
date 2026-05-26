package com.desafiotecnico.pedido_atendimento.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import com.desafiotecnico.pedido_atendimento.domain.enums.PedidoStatusEnum;
import jakarta.persistence.*;

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String clienteId;
    
    @Column(nullable = false)
    private PedidoStatusEnum status;
    
    @ElementCollection
    @CollectionTable(name = "pedido_itens", joinColumns = @JoinColumn(name = "pedido_id"))
    @Column(name = "itens")
    private List<Item> itens = new ArrayList<>();

    @Column
    private BigDecimal total;
    
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;

    
    public void calcularTotal() {

        BigDecimal soma = BigDecimal.ZERO;

        for (Item item : itens) {
            BigDecimal preco = item.getPrecoUnitario();
            int quantidade = item.getQuantidade();

            BigDecimal totalItem = preco.multiply(BigDecimal.valueOf(quantidade));
            soma = soma.add(totalItem);
        }

        this.total = soma;                
    }    

}
