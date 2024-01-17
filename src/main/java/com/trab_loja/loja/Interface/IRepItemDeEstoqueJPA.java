package com.trab_loja.loja.Interface;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trab_loja.loja.Dominio.Entidades.ItemDeEstoque;

public interface IRepItemDeEstoqueJPA extends CrudRepository<ItemDeEstoque, Long>{
    List<ItemDeEstoque> findAll();
    ItemDeEstoque findById(long id);
    void deleteById(long id);
    boolean existsById(long id);
}
