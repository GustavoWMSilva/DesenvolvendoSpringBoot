package com.trab_loja.loja.Dominio.Servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trab_loja.loja.Dominio.Entidades.ItemDeEstoque;
import com.trab_loja.loja.Dominio.Entidades.ItemPedido;
import com.trab_loja.loja.Dominio.Entidades.Orcamento;
import com.trab_loja.loja.Dominio.Entidades.Pedido;
import com.trab_loja.loja.Dominio.Entidades.Produto;
import com.trab_loja.loja.Dominio.Repositorios.IRepItemDeEstoque;
import com.trab_loja.loja.Dominio.Repositorios.IRepProdutos;


@Service
public class ServicoEstoque {
    @Autowired
    private IRepProdutos produtosRep;
    @Autowired
    private IRepItemDeEstoque itemEstoqueRep;

    
    
    public ServicoEstoque(IRepProdutos produtosRep, IRepItemDeEstoque itemEstoqueRep) {

        this.produtosRep = produtosRep;
        this.itemEstoqueRep = itemEstoqueRep;
    }

    public double calcSomatorioPrecos(Pedido novoPedido){
        double total = 0.0;
        List<ItemPedido> itensPedido = novoPedido.getItens_pedido();
        for(ItemPedido i : itensPedido){
            if(itemEstoqueRep.existsById(i.getCod_produto())){
                total += produtoPorID(i.getCod_produto()).getPreco() * i.getQtd();
            }
        }
        return total;
    }

    public List<Produto> produtosDisponiveis() {
        return produtosRep.findAll();
    }

    public Produto produtoPorID(long id) {
        return produtosRep.findById(id);
    }

    public void delete(long id){
        produtosRep.deleteById(id);
    }
    
    public Orcamento efetivarOrcamento(Orcamento orc) throws Exception {
        List<ItemPedido> itens = orc.getPedido().getItens_pedido();
        for (ItemPedido item : itens) {
            if (item.getQtd() > itemEstoqueRep.findById(item.getCod_produto()).getQtdAtual())
                throw new Exception("Não há itens suficientes no estoque");
        }
        for(ItemPedido item : itens){
            ItemDeEstoque aux = itemEstoqueRep.findById(item.getCod_produto());
            aux.setQtdAtual(aux.getQtdAtual() - item.getQtd());
            itemEstoqueRep.update(aux);
        }
        orc.setEfetivado(true);
        return orc;
    }


}

