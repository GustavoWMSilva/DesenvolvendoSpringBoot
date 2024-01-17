package com.trab_loja.loja.Aplicacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trab_loja.loja.Dominio.Entidades.Orcamento;
import com.trab_loja.loja.Dominio.Entidades.Pedido;
import com.trab_loja.loja.Dominio.Servicos.ServicoEstoque;
import com.trab_loja.loja.Dominio.Servicos.ServicoVendas;

@Component
public class SolicitarOrcamento {
    @Autowired
    private ServicoVendas servicoVendas;

    @Autowired
    private ServicoEstoque servicoEstoque;

    public Orcamento run(Pedido novoPedido) throws Exception{
        double somaPrecos = servicoEstoque.calcSomatorioPrecos(novoPedido);
        return servicoVendas.solicitarOrcamento(novoPedido, somaPrecos);
    }

}
