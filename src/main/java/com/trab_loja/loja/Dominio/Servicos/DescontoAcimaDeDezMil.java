package com.trab_loja.loja.Dominio.Servicos;

import java.util.List;
import java.util.stream.Collectors;

import com.trab_loja.loja.Dominio.Entidades.ItemPedido;
import com.trab_loja.loja.Dominio.Entidades.Orcamento;

public class DescontoAcimaDeDezMil implements Desconto {

    public static double calcularMediaUltimas3Compras(List<Orcamento> orcamentosCliente) {
        if(orcamentosCliente == null){
            return 0.0;
        }
        
        List<Orcamento> orcamentosEfetivados = orcamentosCliente.stream()
                .filter(Orcamento::isEfetivado)
                .sorted((o1, o2) -> o2.getData().compareTo(o1.getData()))
                .limit(3)
                .collect(Collectors.toList());

        if(orcamentosEfetivados.size() < 3){
            return 0.0;
        }

        double totalUltimas3Compras = orcamentosEfetivados.stream()
                .mapToDouble(Orcamento::getTotal_pagar)
                .sum();

        return totalUltimas3Compras / 3;
    }


    @Override
    public double calculaDesconto(List<ItemPedido> itensPedidos, List<Orcamento> orcamentosCliente) {
        double desconto = 0.0;
        double media = calcularMediaUltimas3Compras(orcamentosCliente);

        desconto += 0.10;
        
        //calcula cada 10 mil adicionais
        int valorAdicionalArredondado = (int) Math.floor((media - 10000)/10000);
        desconto += valorAdicionalArredondado * 0.05;
        desconto = Math.min(desconto, 0.30);

        return desconto;
    }

    @Override
    public boolean aplicavel(List<ItemPedido> itensPedidos,List<Orcamento> orcamentosCliente) {

        double media = calcularMediaUltimas3Compras(orcamentosCliente);
        return media > 10000;
    }

    @Override
    public boolean dependente() {
        return true;
    }

}
