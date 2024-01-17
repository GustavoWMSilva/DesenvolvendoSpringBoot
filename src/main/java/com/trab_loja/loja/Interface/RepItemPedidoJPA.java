package com.trab_loja.loja.Interface;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trab_loja.loja.Dominio.Entidades.ItemPedido;
import com.trab_loja.loja.Dominio.Repositorios.IRepItemPedido;

@Repository
public class RepItemPedidoJPA implements IRepItemPedido{
    @Autowired
    private IRepItemPedidoJPA itemPedidoRep;

    public RepItemPedidoJPA(IRepItemPedidoJPA itemPedidoRep){
        this.itemPedidoRep = itemPedidoRep;
    }

    @Override
    public ItemPedido save(ItemPedido itemPedido) {
        return itemPedidoRep.save(itemPedido);
    }

    @Override
    public ItemPedido findById(long itemPedId) {
        return itemPedidoRep.findById(itemPedId);
    }

    @Override
    public List<ItemPedido> findAll() {
        return itemPedidoRep.findAll();
    }

    @Override
    public List<ItemPedido> query(Predicate<ItemPedido> pred) {
        return findAll().stream()
                        .filter(pred)
                        .toList();
    }

    @Override
    public void deleteById(long itemPedId) {
        itemPedidoRep.deleteById(itemPedId);
    }

    @Override
    public void update(ItemPedido item) {
        if(existsById(item.getItem_pedido_id())){
            save(item);
        }
    }

    @Override
    public boolean existsById(long itemPedId) {
        return itemPedidoRep.existsById(itemPedId);
    }
    
}
