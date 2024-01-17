package com.trab_loja.loja.Aplicacao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trab_loja.loja.Dominio.Entidades.ItemPedido;
import com.trab_loja.loja.Dominio.Entidades.Orcamento;
import com.trab_loja.loja.Dominio.Entidades.Pedido;
import com.trab_loja.loja.Dominio.Repositorios.IRepOrcamentos;

@Service
public class ServicoRelatorio {
    
    @Autowired
    private IRepOrcamentos orcamentosRep;

    public ServicoRelatorio(IRepOrcamentos orcamentosRep){
        this.orcamentosRep = orcamentosRep;
    }

    public String produtosMaisVendidos() {
        //Relatorio aux = new Relatorio(orcamentosRep.recuperarTodos());
        List<Orcamento> orcamentos = orcamentosRep.findAll();
        List<Pedido> pedidos = new LinkedList<Pedido>();
        Map<Long, Integer> produtos = new HashMap<>();
        
        for (Orcamento orcamento : orcamentos) {
            Pedido ped = orcamento.getPedido();
            if(ped != null){
                pedidos.add(orcamento.getPedido());
                for (ItemPedido item : ped.getItens_pedido()) {
                    Long codigo = item.getCod_produto();
                    Integer qtd = item.getQtd();
                    produtos.put(codigo, produtos.getOrDefault(codigo, 0) + qtd);
                }
            }
        }

        List<Long> top3 = produtos.entrySet().stream()
                        .sorted((p1, p2) -> Double.compare(p2.getValue(), p1.getValue()))
                        .limit(3)
                        .map(Map.Entry::getKey)
                        .toList();
                                
        StringBuilder resposta = new StringBuilder();
        for (Long chave : top3) {
            resposta.append("\nCodigo produto: " + chave);
            resposta.append("\nQuantidade: ");
            resposta.append(String.valueOf(produtos.get(chave)));
        }

        return resposta.toString();
    }

    public String mesesMovimentados() {
        List<Orcamento> orcamentos = orcamentosRep.findAll();
        List<Pedido> pedidos = new LinkedList<Pedido>();
        Map<Integer, Integer> meses = new HashMap<>(12);

        for (Orcamento orcamento : orcamentos) {
            Pedido ped = orcamento.getPedido();

            if(ped != null){    
                pedidos.add(orcamento.getPedido());
                for (ItemPedido item : orcamento.getPedido().getItens_pedido()) {
                    Integer mes = orcamento.getData().getMonthValue();
                    Integer qtd = item.getQtd();
                    meses.put(mes, meses.getOrDefault(mes, 0) + qtd);
                }
            }
        }

        List<Integer> top3 = meses.entrySet().stream()
                        .sorted((p1, p2) -> Double.compare(p2.getValue(), p1.getValue()))
                        .limit(3)
                        .map(Map.Entry::getKey)
                        .toList();

        StringBuilder resposta = new StringBuilder();
        for (Integer chave : top3) {
                resposta.append("\nMes: " + chave);
                resposta.append("\nQuantidade de itens vendidos: ");
                resposta.append(String.valueOf(meses.get(chave)));
        }

        return resposta.toString();
    }

    public String receitaMediaAnual() {
        List<Orcamento> orcamentos = orcamentosRep.findAll();
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataUltimoAno = dataAtual.minusMonths(12);

        double receita = orcamentos.stream()
                                .filter(p -> p.isEfetivado())
                                .filter(p -> p.getData().isAfter(dataUltimoAno))
                                .mapToDouble(p -> p.getTotal_pagar())
                                .sum();
        
        
        return "Receita media anual("+ dataUltimoAno.toString() + " - "+ dataAtual.toString() +"): R$" + receita / 12;
    }
}
