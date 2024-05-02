package com.laregn.pizzariadakrida.crud.pizzariadakrida.models;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "Pizza_Pedida")
@Entity
public class PizzaPedida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPizzaPedida;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdPizza")
    private Pizza pizza;

    private int quantidade;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "PizzaPedida_has_Ingrediente",
            joinColumns = @JoinColumn(name = "idPizzaPedida"),
            inverseJoinColumns = @JoinColumn(name = "idIngrediente")
    )
    private List<Ingrediente> ingrediente;

    public Long getIdPizzaPedida() {
        return idPizzaPedida;
    }

    public void setIdPizzaPedida(Long idPizzaPedida) {
        this.idPizzaPedida = idPizzaPedida;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<Ingrediente> getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(List<Ingrediente> ingrediente) {
        this.ingrediente = ingrediente;
    }

    public PizzaPedida(Pedido pedido, Pizza pizza, int quantidade, List<Ingrediente> ingrediente) {
        this.pedido = pedido;
        this.pizza = pizza;
        this.quantidade = quantidade;
        this.ingrediente = ingrediente;
    }

    public PizzaPedida() {
    }
}
