package com.trab_loja.loja.Dominio.Servicos;

import java.util.List;

import com.trab_loja.loja.Dominio.Entidades.ItemPedido;

public class ImpostoPadrao implements Imposto {
    @Override
    public double calculaImposto(List<ItemPedido> itensPedidos) {
        return 0.10;
    }

    @Override
    public boolean aplicavel(List<ItemPedido> itensPedidos) {
        return true;
    }
}
