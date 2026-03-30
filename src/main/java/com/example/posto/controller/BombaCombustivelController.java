package com.example.posto.controller;

import com.example.posto.model.BombaCombustivel;
import com.example.posto.service.BombaCombustivelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bombas")
public class BombaCombustivelController {
    
    @Autowired
    private BombaCombustivelService service;
    
    @GetMapping
    public List<BombaCombustivel> getAll() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BombaCombustivel> getById(@PathVariable Long id) {
        Optional<BombaCombustivel> bomba = service.findById(id);
        return bomba.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<BombaCombustivel> create(@Valid @RequestBody BombaCombustivel bombaCombustivel) {
        BombaCombustivel saved = service.save(bombaCombustivel);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<BombaCombustivel> update(@PathVariable Long id, 
                                                  @Valid @RequestBody BombaCombustivel bombaCombustivel) {
        BombaCombustivel updated = service.update(id, bombaCombustivel);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
