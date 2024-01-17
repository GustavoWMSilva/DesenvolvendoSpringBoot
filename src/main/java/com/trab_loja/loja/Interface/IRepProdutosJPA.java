package com.trab_loja.loja.Interface;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trab_loja.loja.Dominio.Entidades.Produto;


public interface IRepProdutosJPA extends CrudRepository<Produto,Long>{
    List<Produto> findAll();
    Produto findById(long codProduto);
}
