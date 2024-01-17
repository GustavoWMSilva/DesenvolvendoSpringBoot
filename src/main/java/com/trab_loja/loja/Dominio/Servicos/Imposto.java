package com.trab_loja.loja.Dominio.Servicos;

import java.util.List;

import com.trab_loja.loja.Dominio.Entidades.ItemPedido;

public interface Imposto {
    public double calculaImposto(List<ItemPedido> itensPedidos);

    public boolean aplicavel(List<ItemPedido> itensPedidos);
}
