package com.example.posto.repository;

import com.example.posto.model.BombaCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BombaCombustivelRepository extends JpaRepository<BombaCombustivel, Long> {
    boolean existsByNome(String nome);
}
