package com.laregn.pizzariadakrida.crud.pizzariadakrida.controller;


import com.laregn.pizzariadakrida.crud.pizzariadakrida.models.Pizza;
import com.laregn.pizzariadakrida.crud.pizzariadakrida.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;

    @PostMapping
    public ResponseEntity<Pizza> criarPizza(@RequestBody Pizza pizza) {
        pizzaRepository.save(pizza);
        return ResponseEntity.status(HttpStatus.CREATED).body(pizza);
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> mostrarPizza() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pizzas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> mostraridPizza(@PathVariable Long id) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if (pizza.isEmpty()) {
            throw new RuntimeException("Pizza não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pizza.get());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizza> atualizarPizza(@PathVariable Long id, @RequestBody Pizza pizza) {
        Optional<Pizza> pizzaDb = pizzaRepository.findById(id);
        if (pizzaDb.isEmpty()) {
            throw new RuntimeException("Pizza não encontrada!");
        }
        pizzaDb.get().setNome(pizza.getNome());
        pizzaDb.get().setPrecoBase(pizza.getPrecoBase());
        pizzaDb.get().setPersonalizada(pizza.isPersonalizada());

        pizzaRepository.save(pizzaDb.get());
        return ResponseEntity.status(HttpStatus.OK).body(pizzaDb.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPizza(@PathVariable Long id) {
        Optional<Pizza> pizzaDb = pizzaRepository.findById(id);
        if (pizzaDb.isEmpty()) {
            throw new RuntimeException("Pizza não encontrada!");
        }
        pizzaRepository.delete(pizzaDb.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pizza deletada com sucesso!");

    }
}
