package com.example.posto.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "abastecimento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Abastecimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "A bomba é obrigatória")
    @ManyToOne
    @JoinColumn(name = "bomba_id", nullable = false)
    private BombaCombustivel bomba;
    
    @NotNull(message = "A data do abastecimento é obrigatória")
    @Column(nullable = false)
    private LocalDateTime data;
    
    @NotNull(message = "O valor total é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero")
    @Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;
    
    @NotNull(message = "A litragem é obrigatória")
    @DecimalMin(value = "0.0", inclusive = false, message = "A litragem deve ser maior que zero")
    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal litragem;
}
