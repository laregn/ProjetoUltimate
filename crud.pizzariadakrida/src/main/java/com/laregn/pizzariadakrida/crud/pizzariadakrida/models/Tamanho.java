package com.laregn.pizzariadakrida.crud.pizzariadakrida.models;

import jakarta.persistence.*;

@Table(name = "Tamanho")
@Entity

public class Tamanho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTamanho;
    private String nome;
    private float desconto;

    public Long getIdTamanho() {
        return idTamanho;
    }

    public void setIdTamanho(Long idTamanho) {
        this.idTamanho = idTamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public Tamanho(String nome, float desconto) {
        this.nome = nome;
        this.desconto = desconto;
    }

    public Tamanho() {
    }
}
