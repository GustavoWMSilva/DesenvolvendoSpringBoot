package com.trab_loja.loja.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "itempedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long item_pedido_id;
    @Column
    private long cod_produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonBackReference
    private Pedido pedido;

    @Column
    private int qtd;
    
    public ItemPedido(long cod_produto, int qtd) {
        this.cod_produto = cod_produto;
        this.qtd = qtd;
    }
    protected ItemPedido(){}

    
    public long getItem_pedido_id() {
        return item_pedido_id;
    }
    public void setItem_pedido_id(long item_pedido_id) {
        this.item_pedido_id = item_pedido_id;
    }

    
    public long getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(long cod_produto) {
        this.cod_produto = cod_produto;
    }
    

    public int getQtd() {
        return qtd;
    }
    
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}