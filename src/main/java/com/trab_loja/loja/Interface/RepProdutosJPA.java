package com.trab_loja.loja.Interface;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.trab_loja.loja.Dominio.Entidades.Produto;
import com.trab_loja.loja.Dominio.Repositorios.IRepProdutos;

@Repository
@Primary
public class RepProdutosJPA implements IRepProdutos {
    @Autowired
    private IRepProdutosJPA repJPA;

    
    public RepProdutosJPA(IRepProdutosJPA repJPA){
        this.repJPA = repJPA;
    }

    @Override
    public Produto save(Produto p) {
        return repJPA.save(p);
    }

    @Override
    public List<Produto> findAll() {
        return repJPA.findAll();
    }

    @Override
    public Produto findById(long codProduto) {
        return repJPA.findById(codProduto);
    }

    @Override
    public List<Produto> query(Predicate<Produto> pred) {
        return findAll().stream()
                            .filter(pred)
                            .toList();
    }

    @Override
    public void deleteById(long codProduto) {
        repJPA.deleteById(codProduto);
    }

    @Override
    public void update(Produto prod) {
        if(existsById(prod.getCodigo())){
            save(prod);
        }
    }

    @Override
    public boolean existsById(long codProduto) {
        return repJPA.existsById(codProduto);
    }
    
}