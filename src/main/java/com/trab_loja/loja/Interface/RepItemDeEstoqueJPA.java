package com.trab_loja.loja.Interface;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trab_loja.loja.Dominio.Entidades.ItemDeEstoque;
import com.trab_loja.loja.Dominio.Repositorios.IRepItemDeEstoque;

@Repository
public class RepItemDeEstoqueJPA implements IRepItemDeEstoque {
    @Autowired
    private IRepItemDeEstoqueJPA rep_estoque;


    public RepItemDeEstoqueJPA(IRepItemDeEstoqueJPA rep_estoque) {
        this.rep_estoque = rep_estoque;
    }


    @Override
    public ItemDeEstoque save(ItemDeEstoque item) {
        return rep_estoque.save(item);
    }

    @Override
    public ItemDeEstoque findById(long item_id) {
        return rep_estoque.findById(item_id);
    }

    @Override
    public List<ItemDeEstoque> findAll() {
        return rep_estoque.findAll();
    }

    @Override
    public List<ItemDeEstoque> query(Predicate<ItemDeEstoque> pred) {
        return findAll().stream()
                .filter(pred)
                .toList();
    }

    @Override
    public void deleteById(long idItem) {
        rep_estoque.deleteById(idItem);
    }

    @Override
    public void update(ItemDeEstoque item) {
        if(existsById(item.getIdItem())){
            save(item);
        }
    }

    @Override
    public boolean existsById(long idItem) {
        return rep_estoque.existsById(idItem);
    }

}
