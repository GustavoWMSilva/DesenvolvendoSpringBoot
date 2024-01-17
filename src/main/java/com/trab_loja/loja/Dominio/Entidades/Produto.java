package com.trab_loja.loja.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "itemdeestoque_id")
    @JsonManagedReference
    private ItemDeEstoque itemdeestoque;

    @Column
    private String descricao;
    @Column
    private double preco;

    protected Produto() {
    }

    
    public long getCodigo() {
        return codigo;
    }


    public ItemDeEstoque getItemdeestoque() {
        return itemdeestoque;
    }

    
    public String getDescricao() {
        return descricao;
    }

    
    public double getPreco() {
        return preco;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setItemdeestoque(ItemDeEstoque itemdeestoque) {
        this.itemdeestoque = itemdeestoque;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + "]";
    }
}
