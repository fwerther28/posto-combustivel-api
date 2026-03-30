package com.example.posto.service;

import com.example.posto.model.BombaCombustivel;
import com.example.posto.repository.BombaCombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BombaCombustivelService {
    
    @Autowired
    private BombaCombustivelRepository repository;
    
    public List<BombaCombustivel> findAll() {
        return repository.findAll();
    }
    
    public Optional<BombaCombustivel> findById(Long id) {
        return repository.findById(id);
    }
    
    public BombaCombustivel save(BombaCombustivel bombaCombustivel) {
        return repository.save(bombaCombustivel);
    }
    
    public BombaCombustivel update(Long id, BombaCombustivel bombaCombustivel) {
        if (repository.existsById(id)) {
            bombaCombustivel.setId(id);
            return repository.save(bombaCombustivel);
        }
        return null;
    }
    
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
