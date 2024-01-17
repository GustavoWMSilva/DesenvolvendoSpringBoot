package com.trab_loja.loja.Dominio.Repositorios;

import java.util.List;
import java.util.function.Predicate;

import com.trab_loja.loja.Dominio.Entidades.Produto;

public interface IRepProdutos {
    Produto save(Produto prod);
    Produto findById(long codProduto);
    List<Produto> findAll();
    List<Produto> query(Predicate<Produto> pred);
    void deleteById(long codProduto);
    void update(Produto prod);
    boolean existsById(long codProduto);
}
