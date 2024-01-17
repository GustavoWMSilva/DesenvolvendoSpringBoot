package com.trab_loja.loja.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GerarRelatorio {
    @Autowired
    private ServicoRelatorio servicoRelatorio;

    public String run(String nome){
        
        // top 3 produtos mais vendidos
        if (nome.equals("maisVendidos")) {
            return servicoRelatorio.produtosMaisVendidos();
        }
        // top 3 meses mais movimentados (com itens mais vendidos)
        else if(nome.equals("meses")) {
            return servicoRelatorio.mesesMovimentados();
        }
        // receita media anual
        else if (nome.equals("receita")) {
            return servicoRelatorio.receitaMediaAnual();
        }
        else return "Tipo de relatório inexistente";
    }

    // public String test() {
    //     return servicoRelatorio.teste();
    // }
}
