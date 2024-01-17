package com.trab_loja.loja.Dominio.Entidades;

// import java.util.List;
import java.time.LocalDate;

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
@Table(name = "orcamento")
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orc")
    private long id_orc;
    
    @Column(name = "data")
    private LocalDate data;
    @Column(name = "nome_cliente")
    private String nome_cliente;

    
    
    @OneToOne (mappedBy = "orcamento", cascade = CascadeType.ALL)
    @JoinColumn(name = "ped_id")
    @JsonManagedReference
    private Pedido pedido;

    @Column(name = "custo_pedido")
    private double custo_pedido;
    @Column(name = "imposto")
    private double imposto;
    @Column(name = "desconto")
    private double desconto;
    @Column(name = "total_pagar")
    private double total_pagar;
    @Column(name = "efetivado")
    private boolean efetivado;

    protected Orcamento() {

    }
    
    public Orcamento(LocalDate data, String nome_cliente, Pedido pedido, double custo_pedido,
            double imposto, double desconto,double total_pagar) {
        
        // this.id_orc = id_orc;
        this.data = data;
        this.nome_cliente = nome_cliente;
        this.pedido = pedido;
        this.custo_pedido = custo_pedido;
        this.imposto = imposto;
        this.desconto = desconto;
        this.total_pagar = total_pagar;
        this.efetivado = false;
    }

    
    public long getid_orc() {
        return id_orc;
    }

    public void setid_orc(long id_orc) {
        this.id_orc = id_orc;
    }

    
    public void setCusto_pedido(double custo_pedido) {
        this.custo_pedido = custo_pedido;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public void setTotal_pagar(double total_pagar) {
        this.total_pagar = total_pagar;
    }

   
    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    
    public boolean isEfetivado() {
        return efetivado;
    }

    public void setEfetivado(boolean efetivado) {
        this.efetivado = efetivado;
    }

  
    public LocalDate getData() {
        return data;
    }

    
    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    
    public double getCusto_pedido() {
        return custo_pedido;
    }

    
    public double getImposto() {
        return imposto;
    }

    
    public double getTotal_pagar() {
        return total_pagar;
    }

    @Override
    public String toString() {
        return "Orcamento [id_orc=" + id_orc + ", data=" + data + ", nome_cliente=" + nome_cliente + ", pedido=" + pedido
                + ", custo_pedido=" + custo_pedido + ", imposto=" + imposto + ", desconto=" + desconto
                + ", total_pagar="
                + total_pagar + ", efetivado=" + efetivado + "]";
    }

}