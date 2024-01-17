package com.trab_loja.loja.Dominio.Servicos;

import java.util.List;

import com.trab_loja.loja.Dominio.Entidades.ItemPedido;
import com.trab_loja.loja.Dominio.Entidades.Orcamento;

public class DescontoPadrao implements Desconto {

    // o padrão é 5% para pedidos com mais de 5 itens
    @Override
    public double calculaDesconto(List<ItemPedido> itensPedidos, List<Orcamento> orcamentosCliente) {
        return 0.05;
    }

    @Override
    public boolean aplicavel(List<ItemPedido> itensPedidos, List<Orcamento> orcamentosCliente) {
        int qtd = itensPedidos.stream()
                .mapToInt(p -> p.getQtd())
                .sum();

        return qtd > 5;
    }

    @Override
    public boolean dependente() {
        return false;
    }
}
