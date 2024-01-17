package com.trab_loja.loja.Interface;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trab_loja.loja.Dominio.Entidades.Pedido;

public interface IRepPedidosJPA extends CrudRepository<Pedido,Long>{
    List<Pedido> findAll();
    Pedido findById(long idPedido);
}
