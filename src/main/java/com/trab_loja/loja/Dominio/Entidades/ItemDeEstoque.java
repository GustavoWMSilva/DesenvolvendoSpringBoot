package com.trab_loja.loja.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "itemdeestoque")
public class ItemDeEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long item_id;

    @OneToOne
    @JoinColumn(name = "codigo")
    @JsonBackReference
    private Produto produto;
    
    @Column
    private int qtd_atual;
    @Column
    private int estoque_min;
    @Column
    private int estoque_max;

    
    public long getIdItem() {
        return item_id;
    }

    public void setIdItem(long item_id) {
        this.item_id = item_id;
    }

    
    public int getQtdAtual() {
        return qtd_atual;
    }

    public void setQtdAtual(int qtd_atual) {
        this.qtd_atual = qtd_atual;
    }

    
    public int getEstoqueMin() {
        return estoque_min;
    }

    public void setEstoqueMin(int estoque_min) {
        this.estoque_min = estoque_min;
    }

    
    public int getEstoqueMax() {
        return estoque_max;
    }

    public void setEstoqueMax(int estoque_max) {
        this.estoque_max = estoque_max;
    }


    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}