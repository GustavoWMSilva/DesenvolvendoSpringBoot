package com.trab_loja.loja.Interface;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trab_loja.loja.Dominio.Entidades.Pedido;
import com.trab_loja.loja.Dominio.Repositorios.IRepPedidos;

@Repository
public class RepPedidosJPA implements IRepPedidos{
    @Autowired
    private IRepPedidosJPA pedidosRep;

    public RepPedidosJPA(IRepPedidosJPA pedidosRep){
        this.pedidosRep = pedidosRep;
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidosRep.save(pedido);
    }

    @Override
    public Pedido findById(long pedId) {
        return pedidosRep.findById(pedId);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidosRep.findAll();
    }

    @Override
    public List<Pedido> query(Predicate<Pedido> pred) {
        return findAll().stream()
                        .filter(pred)
                        .toList();
    }

    @Override
    public void deleteById(long pedId) {
        pedidosRep.deleteById(pedId);
    }

    @Override
    public void update(Pedido pedido) {
        if(existsById(pedido.getPed_id())){
            save(pedido);
        }
    }

    @Override
    public boolean existsById(long pedId) {
        return pedidosRep.existsById(pedId);
    }

    
    
}
