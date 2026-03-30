package com.example.posto.controller;

import com.example.posto.model.Abastecimento;
import com.example.posto.service.AbastecimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/abastecimentos")
public class AbastecimentoController {
    
    @Autowired
    private AbastecimentoService service;
    
    @GetMapping
    public List<Abastecimento> getAll() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Abastecimento> getById(@PathVariable Long id) {
        Optional<Abastecimento> abastecimento = service.findById(id);
        return abastecimento.map(ResponseEntity::ok)
                           .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Abastecimento> create(@Valid @RequestBody Abastecimento abastecimento) {
        Abastecimento saved = service.save(abastecimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Abastecimento> update(@PathVariable Long id, 
                                               @Valid @RequestBody Abastecimento abastecimento) {
        Abastecimento updated = service.update(id, abastecimento);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}