package com.example.posto.service;

import com.example.posto.model.Abastecimento;
import com.example.posto.repository.AbastecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AbastecimentoService {
    
    @Autowired
    private AbastecimentoRepository repository;
    
    public List<Abastecimento> findAll() {
        return repository.findAll();
    }
    
    public Optional<Abastecimento> findById(Long id) {
        return repository.findById(id);
    }
    
    public Abastecimento save(Abastecimento abastecimento) {
        return repository.save(abastecimento);
    }
    
    public Abastecimento update(Long id, Abastecimento abastecimento) {
        if (repository.existsById(id)) {
            abastecimento.setId(id);
            return repository.save(abastecimento);
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
