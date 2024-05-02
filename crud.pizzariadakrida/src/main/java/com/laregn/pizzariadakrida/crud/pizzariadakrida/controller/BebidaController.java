package com.laregn.pizzariadakrida.crud.pizzariadakrida.controller;


import com.laregn.pizzariadakrida.crud.pizzariadakrida.models.Bebida;
import com.laregn.pizzariadakrida.crud.pizzariadakrida.repositories.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bebidas")
public class BebidaController {
    @Autowired
    private BebidaRepository bebidaRepository;

    @PostMapping
    public ResponseEntity<Bebida> criarBebida(@RequestBody Bebida bebida) {
        bebidaRepository.save(bebida);
        return ResponseEntity.status(HttpStatus.CREATED).body(bebida);
    }

    @GetMapping
    public ResponseEntity<List<Bebida>> mostrarBebida() {
        List<Bebida> bebidas = bebidaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(bebidas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bebida> mostraridBebida(@PathVariable Long id) {
        Optional<Bebida> bebida = bebidaRepository.findById(id);
        if (bebida.isEmpty()) {
            throw new RuntimeException("Bebida não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bebida.get());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Bebida> atualizarBebida(@PathVariable Long id, @RequestBody Bebida bebida) {
        Optional<Bebida> bebidaDb = bebidaRepository.findById(id);
        if (bebidaDb.isEmpty()) {
            throw new RuntimeException("Bebida não encontrada!");
        }
        bebidaDb.get().setNome(bebida.getNome());
        bebidaDb.get().setPreco(bebida.getPreco());

        bebidaRepository.save(bebidaDb.get());
        return ResponseEntity.status(HttpStatus.OK).body(bebidaDb.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarBebida(@PathVariable Long id) {
        Optional<Bebida> bebidaDb = bebidaRepository.findById(id);
        if (bebidaDb.isEmpty()) {
            throw new RuntimeException("Bebida não encontrada!");
        }
        bebidaRepository.delete(bebidaDb.get());
        return ResponseEntity.status(HttpStatus.OK).body("Bebida deletada com sucesso!");

    }
}
