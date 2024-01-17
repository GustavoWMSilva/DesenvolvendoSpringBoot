package com.trab_loja.loja.Dominio.Repositorios;

import java.util.List;
import java.util.function.Predicate;

import com.trab_loja.loja.Dominio.Entidades.ItemPedido;

public interface IRepItemPedido {
    ItemPedido save(ItemPedido itemPedido);
    ItemPedido findById(long itemPedId);
    List<ItemPedido> findAll();
    List<ItemPedido> query(Predicate<ItemPedido> pred);
    void deleteById(long itemPedId);
    void update(ItemPedido pedido) ;
    boolean existsById(long itemPedId);
}
