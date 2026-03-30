package com.example.posto.controller;

import com.example.posto.model.TipoCombustivel;
import com.example.posto.service.TipoCombustivelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipos-combustivel")
public class TipoCombustivelController {
    
    @Autowired
    private TipoCombustivelService service;
    
    @GetMapping
    public List<TipoCombustivel> getAll() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoCombustivel> getById(@PathVariable Long id) {
        Optional<TipoCombustivel> tipo = service.findById(id);
        return tipo.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody TipoCombustivel tipoCombustivel) {
        try {
            // Verifica se já existe um tipo com mesmo nome
            if (service.existsByNome(tipoCombustivel.getNome())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Erro: Já existe um tipo de combustível com o nome '" + tipoCombustivel.getNome() + "'");
            }
            
            // Salva o novo tipo
            TipoCombustivel saved = service.save(tipoCombustivel);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno do servidor: " + e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoCombustivel> update(@PathVariable Long id, 
                                                 @Valid @RequestBody TipoCombustivel tipoCombustivel) {
        try {
            TipoCombustivel updated = service.update(id, tipoCombustivel);
            return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            boolean deleted = service.delete(id);
            return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}