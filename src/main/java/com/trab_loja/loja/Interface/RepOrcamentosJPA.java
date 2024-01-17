package com.trab_loja.loja.Interface;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trab_loja.loja.Dominio.Entidades.Orcamento;
import com.trab_loja.loja.Dominio.Repositorios.IRepOrcamentos;

@Repository
public class RepOrcamentosJPA implements IRepOrcamentos{
    @Autowired
    private IRepOrcamentosJPA orcamentos;

    public RepOrcamentosJPA(IRepOrcamentosJPA orcamentos) {
        this.orcamentos = orcamentos;
    }

    @Override
    public Orcamento save(Orcamento orc) {
        return orcamentos.save(orc);
    }

    @Override
    public Orcamento findById(long idOrc) {
        return orcamentos.findById(idOrc);
    }

    @Override
    public List<Orcamento> findAll() {
        return orcamentos.findAll();
    }

    @Override
    public List<Orcamento> findByNome_cliente(String nome_cliente){
        return orcamentos.findByNome_cliente(nome_cliente);
    }
    @Override
    public List<Orcamento> query(Predicate<Orcamento> pred) {
        return findAll().stream()
                        .filter(pred)
                        .toList();
    }

    @Override
    public void deleteById(long idOrc) {
        orcamentos.deleteById(idOrc);
    }

    @Override
    public void update(Orcamento orc) {
        if(existsById(orc.getid_orc())){
            save(orc);
        }
    }

    @Override
    public boolean existsById(long idOrc) {
        return orcamentos.existsById(idOrc);
    }
    
}
