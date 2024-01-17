package com.trab_loja.loja.Dominio.Servicos;

import java.time.LocalDate;
import java.util.List;

import com.trab_loja.loja.Dominio.Entidades.ItemPedido;
import com.trab_loja.loja.Dominio.Entidades.Orcamento;

public class DescontoMaisDeDezCompras implements Desconto {
    public double calculaDesconto(List<ItemPedido> itensPedidos, List<Orcamento> orcamentosClientes) {
        double desconto = 0.25; // Desconto de 25%
        return desconto;
    }

    public boolean aplicavel(List<ItemPedido> itensPedidos, List<Orcamento> orcamentosClientes) {
        // Obtém a data atual
        LocalDate dataAtual = LocalDate.now();

        // Obtém a data atual menos 6 meses
        LocalDate dataHá6Meses = dataAtual.minusMonths(6);

        // Filtra os Orcamentos efetivados nos últimos 6 meses
        int numeroCompras = (int) orcamentosClientes.stream()
                .filter(orcamento -> orcamento.isEfetivado() && orcamento.getData().isAfter(dataHá6Meses))
                .count();

        return numeroCompras > 10;
    }

    public boolean dependente() {
        return true;
    }

}
