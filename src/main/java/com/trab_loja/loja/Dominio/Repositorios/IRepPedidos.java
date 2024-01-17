package com.trab_loja.loja.Dominio.Repositorios;

import java.util.List;
import java.util.function.Predicate;

import com.trab_loja.loja.Dominio.Entidades.Pedido;

public interface IRepPedidos {
    Pedido save(Pedido pedido);
    Pedido findById(long pedId);
    List<Pedido> findAll();
    List<Pedido> query(Predicate<Pedido> pred);
    void deleteById(long pedId);
    void update(Pedido pedido) ;
    boolean existsById(long pedId);
}
