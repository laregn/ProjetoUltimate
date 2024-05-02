package com.laregn.pizzariadakrida.crud.pizzariadakrida.controller;


import com.laregn.pizzariadakrida.crud.pizzariadakrida.models.Fornada;
import com.laregn.pizzariadakrida.crud.pizzariadakrida.repositories.FornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornadas")
public class FornadaController {
    @Autowired
    private FornadaRepository fornadaRepository;

    @PostMapping
    public ResponseEntity<Fornada> criarFornada(@RequestBody Fornada fornada) {
        fornadaRepository.save(fornada);
        return ResponseEntity.status(HttpStatus.CREATED).body(fornada);
    }

    @GetMapping
    public ResponseEntity<List<Fornada>> mostrarFornada() {
        List<Fornada> fornadas = fornadaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(fornadas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornada> mostraridFornada(@PathVariable Long id) {
        Optional<Fornada> fornada = fornadaRepository.findById(id);
        if (fornada.isEmpty()) {
            throw new RuntimeException("Fornada não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(fornada.get());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornada> atualizarFornada(@PathVariable Long id, @RequestBody Fornada fornada) {
        Optional<Fornada> fornadaDb = fornadaRepository.findById(id);
        if (fornadaDb.isEmpty()) {
            throw new RuntimeException("Fornada não encontrada!");
        }
        fornadaDb.get().setNumFornada(fornada.getNumFornada());
        fornadaDb.get().setQtdPizza(fornada.getQtdPizza());

        fornadaRepository.save(fornadaDb.get());
        return ResponseEntity.status(HttpStatus.OK).body(fornadaDb.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarFornada(@PathVariable Long id) {
        Optional<Fornada> fornadaDb = fornadaRepository.findById(id);
        if (fornadaDb.isEmpty()) {
            throw new RuntimeException("Fornada não encontrada!");
        }
        fornadaRepository.delete(fornadaDb.get());
        return ResponseEntity.status(HttpStatus.OK).body("Fornada deletada com sucesso!");

    }
}
