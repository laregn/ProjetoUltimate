package com.laregn.pizzariadakrida.crud.pizzariadakrida.controller;

import com.laregn.pizzariadakrida.crud.pizzariadakrida.models.Cliente;
import com.laregn.pizzariadakrida.crud.pizzariadakrida.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> mostrarCliente() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> mostraridPizza(@PathVariable Long id) {
        Optional<Cliente> clientes = clienteRepository.findById(id);
        if (clientes.isEmpty()) {
            throw new RuntimeException("Cliente não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientes.get());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteDb = clienteRepository.findById(id);
        if (clienteDb.isEmpty()) {
            throw new RuntimeException("Cliente não encontrada!");
        }
        clienteDb.get().setNome(cliente.getNome());
        clienteDb.get().setTelefone(cliente.getTelefone());
        clienteDb.get().setEndereco(cliente.getEndereco());
        clienteDb.get().setLogin(cliente.getLogin());
        clienteDb.get().setSenha(cliente.getSenha());


        clienteRepository.save(clienteDb.get());
        return ResponseEntity.status(HttpStatus.OK).body(clienteDb.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Long id) {
        Optional<Cliente> clienteDb = clienteRepository.findById(id);
        if (clienteDb.isEmpty()) {
            throw new RuntimeException("Cliente não encontrada!");
        }
        clienteRepository.delete(clienteDb.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletada com sucesso!");

    }
}
