package com.trab_loja.loja.Dominio.Entidades;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ped_id;
    @Column
    private String nome_cliente;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    @JsonManagedReference
    private List<ItemPedido> itens_pedido;

    @OneToOne
    @JoinColumn(name = "id_orc")
    @JsonBackReference
    private Orcamento orcamento;

    public Pedido() {
    }
    public Pedido(String nome_cliente, List<ItemPedido> itens_pedido){
        this.nome_cliente = nome_cliente;
        this.itens_pedido = itens_pedido;
    }

    
    public List<ItemPedido> getItens_pedido() {
        return itens_pedido;
    }

    
    public String getNome_cliente() {
        return nome_cliente;
    }

    
    public long getPed_id() {
        return ped_id;
    }


    public void setItens_pedidos(List<ItemPedido> itens_pedido) {
        this.itens_pedido = itens_pedido;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public void setPed_id(long ped_id) {
        this.ped_id = ped_id;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }
    
    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

}
