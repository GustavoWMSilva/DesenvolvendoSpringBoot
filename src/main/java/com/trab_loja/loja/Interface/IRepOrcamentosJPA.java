package com.trab_loja.loja.Interface;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.trab_loja.loja.Dominio.Entidades.Orcamento;

import java.util.List;


public interface IRepOrcamentosJPA extends CrudRepository<Orcamento, Long>{
    Orcamento findById(long id_orc);
    List<Orcamento> findAll();
    void deleteById(long id_orc);
    boolean existsById(long id_orc);
    @Query("SELECT o FROM Orcamento o WHERE o.nome_cliente = :nomeCliente")
    List<Orcamento> findByNome_cliente(@Param("nomeCliente") String nomeCliente);
}
