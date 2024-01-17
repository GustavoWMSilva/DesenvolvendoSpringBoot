package com.trab_loja.loja.Interface;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trab_loja.loja.Dominio.Entidades.ItemPedido;

public interface IRepItemPedidoJPA extends CrudRepository<ItemPedido,Long>{
    List<ItemPedido> findAll();
    ItemPedido findById(long idItem);
}
