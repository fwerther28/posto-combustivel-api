package com.example.posto.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Entity
@Table(name = "tipo_combustivel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoCombustivel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome do combustível é obrigatório")
    @Column(nullable = false, unique = true)
    private String nome;
    
    @NotNull(message = "O preço por litro é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero")
    @Column(name = "preco_litro", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoPorLitro;
}
