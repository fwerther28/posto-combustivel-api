package com.example.posto.service;

import com.example.posto.model.TipoCombustivel;
import com.example.posto.repository.TipoCombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TipoCombustivelService {
    
    @Autowired
    private TipoCombustivelRepository repository;
    
    public List<TipoCombustivel> findAll() {
        return repository.findAll();
    }
    
    public Optional<TipoCombustivel> findById(Long id) {
        return repository.findById(id);
    }
    
    public TipoCombustivel save(TipoCombustivel tipoCombustivel) {
        return repository.save(tipoCombustivel);
    }
    
    public TipoCombustivel update(Long id, TipoCombustivel tipoCombustivel) {
        if (repository.existsById(id)) {
            tipoCombustivel.setId(id);
            return repository.save(tipoCombustivel);
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
    
    public boolean existsByNome(String nome) {
        return repository.existsByNome(nome);
    }
}
