package com.trab_loja.loja.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trab_loja.loja.Dominio.Entidades.Produto;
import com.trab_loja.loja.Dominio.Servicos.ServicoEstoque;

@Component
public class ProdutosDisponiveis_UC {
    @Autowired
    private ServicoEstoque servicoEstoque;

    public List<Produto> run(){
        return servicoEstoque.produtosDisponiveis();
    }

}
