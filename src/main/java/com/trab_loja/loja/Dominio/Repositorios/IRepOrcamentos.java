package com.trab_loja.loja.Dominio.Repositorios;

import java.util.List;
import java.util.function.Predicate;

import com.trab_loja.loja.Dominio.Entidades.Orcamento;

public interface IRepOrcamentos {
    Orcamento save(Orcamento orc);
    Orcamento findById(long idOrc);
    List<Orcamento> findAll();
    List<Orcamento> query(Predicate<Orcamento> pred);
    void deleteById(long idOrc);
    void update(Orcamento orc) ;
    boolean existsById(long idOrc);
    public List<Orcamento> findByNome_cliente(String nome_cliente);

}
