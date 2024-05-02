package com.laregn.pizzariadakrida.crud.pizzariadakrida.models;

import jakarta.persistence.*;

@Table(name = "Bebida")
@Entity
public class Bebida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBebida;
    private String nome;
    private float preco;

    public Long getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(Long idBebida) {
        this.idBebida = idBebida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Bebida( String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Bebida() {
    }
}
