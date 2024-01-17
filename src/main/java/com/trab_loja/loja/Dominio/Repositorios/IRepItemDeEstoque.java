package com.trab_loja.loja.Dominio.Repositorios;

import java.util.List;
import java.util.function.Predicate;

import com.trab_loja.loja.Dominio.Entidades.ItemDeEstoque;

public interface IRepItemDeEstoque {
    ItemDeEstoque save(ItemDeEstoque item);

    ItemDeEstoque findById(long idItem);

    List<ItemDeEstoque> findAll();

    List<ItemDeEstoque> query(Predicate<ItemDeEstoque> pred);

    void deleteById(long idItem);

   void update(ItemDeEstoque item);

    boolean existsById(long idItem);
}
