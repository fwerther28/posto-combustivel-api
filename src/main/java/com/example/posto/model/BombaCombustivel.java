package com.example.posto.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "bomba_combustivel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BombaCombustivel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome da bomba é obrigatório")
    @Column(nullable = false)
    private String nome;
    
    @NotNull(message = "O tipo de combustível é obrigatório")
    @ManyToOne
    @JoinColumn(name = "tipo_combustivel_id", nullable = false)
    private TipoCombustivel combustivel;
}
