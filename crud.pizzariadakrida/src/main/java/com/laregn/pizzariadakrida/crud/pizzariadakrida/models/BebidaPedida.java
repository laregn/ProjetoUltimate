package com.laregn.pizzariadakrida.crud.pizzariadakrida.models;

import jakarta.persistence.*;

@Table(name = "Bebida_Pedida")
@Entity
public class BebidaPedida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBebidaPedida;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    private int quantidade;

    public Long getIdBebidaPedida() {
        return idBebidaPedida;
    }

    public void setIdBebidaPedida(Long idBebidaPedida) {
        this.idBebidaPedida = idBebidaPedida;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BebidaPedida(Pedido pedido, int quantidade) {
        this.pedido = pedido;
        this.quantidade = quantidade;
    }

    public BebidaPedida() {
    }
}




