package com.trab_loja.loja.Dominio.Servicos;

import java.util.List;

import com.trab_loja.loja.Dominio.Entidades.ItemPedido;
import com.trab_loja.loja.Dominio.Entidades.Orcamento;

public interface Desconto {
    public double calculaDesconto(List<ItemPedido> itensPedidos, List<Orcamento> orcamentosCliente);//mudar depois
    public boolean aplicavel(List<ItemPedido> itensPedidos, List<Orcamento> orcamentosCliente);
    public boolean dependente();
}
