package com.laregn.pizzariadakrida.crud.pizzariadakrida.models;

import jakarta.persistence.*;

@Table(name = "Fornada")
@Entity
public class Fornada {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFornada;
    private int numFornada;
    private int qtdPizza;

    public Long getIdFornada() {
        return idFornada;
    }

    public void setIdFornada(Long idFornada) {
        this.idFornada = idFornada;
    }

    public int getNumFornada() {
        return numFornada;
    }

    public void setNumFornada(int numFornada) {
        this.numFornada = numFornada;
    }

    public int getQtdPizza() {
        return qtdPizza;
    }

    public void setQtdPizza(int qtdPizza) {
        this.qtdPizza = qtdPizza;
    }

    public Fornada(int numFornada, int qtdPizza) {
        this.numFornada = numFornada;
        this.qtdPizza = qtdPizza;
    }

    public Fornada() {
    }
}
