package com.laregn.pizzariadakrida.crud.pizzariadakrida.models;

import jakarta.persistence.*;

@Table(name = "Pizzas")
@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPizza;
    private String nome;
    private float precoBase;
    private boolean personalizada;

    public Long getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(Long idPizza) {
        this.idPizza = idPizza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(float precoBase) {
        this.precoBase = precoBase;
    }

    public boolean isPersonalizada() {
        return personalizada;
    }

    public void setPersonalizada(boolean personalizada) {
        this.personalizada = personalizada;
    }

    public Pizza(String nome, float precoBase, boolean personalizada) {
        this.nome = nome;
        this.precoBase = precoBase;
        this.personalizada = personalizada;
    }

    public Pizza() {
    }
}


