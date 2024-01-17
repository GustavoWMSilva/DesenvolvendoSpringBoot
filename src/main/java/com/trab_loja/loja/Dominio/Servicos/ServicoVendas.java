package com.trab_loja.loja.Dominio.Servicos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trab_loja.loja.Dominio.Entidades.ItemPedido;
import com.trab_loja.loja.Dominio.Entidades.Orcamento;
import com.trab_loja.loja.Dominio.Entidades.Pedido;
import com.trab_loja.loja.Dominio.Repositorios.IRepItemPedido;
import com.trab_loja.loja.Dominio.Repositorios.IRepOrcamentos;
import com.trab_loja.loja.Dominio.Repositorios.IRepPedidos;

@Service
public class ServicoVendas {
    @Autowired
    private IRepOrcamentos orcamentosRep;

    @Autowired
    private IRepPedidos pedidosRep;

    @Autowired
    private IRepItemPedido itemPedidoRep;

    private List<Desconto> descontos;
    private List<Imposto> impostos;

    
    @Autowired
    public ServicoVendas(IRepOrcamentos orcamentosRep, IRepPedidos pedidosRep, IRepItemPedido itemPedidoRep) {
        this.orcamentosRep = orcamentosRep;
        this.pedidosRep = pedidosRep;
        this.itemPedidoRep = itemPedidoRep;

        descontos = new LinkedList<>();

        descontos.add(new DescontoPadrao());
        descontos.add(new DescontoAcimaDeDezMil());
        descontos.add(new DescontoMaisDeDezCompras());

        impostos = new LinkedList<>();
        impostos.add(new ImpostoPadrao());
    }



    public Orcamento geraOrcamento(Pedido novoPedido, double somaPrecos) throws Exception {
        double desconto = 0.0;
        double imposto = 0.0;
        double totalDaCompra = 0.0;
        if(novoPedido.getItens_pedido().size() == 0){
            throw new Exception("A lista de itens está vazia");
        }

        Orcamento novoOrcamento = new Orcamento(null, novoPedido.getNome_cliente(), novoPedido, somaPrecos, imposto, desconto, totalDaCompra);
        orcamentosRep.save(novoOrcamento);

        List<ItemPedido> itensPedidos = novoPedido.getItens_pedido();

        List<Double> dependentes = new ArrayList<>();
        List<Orcamento> orcamentos = orcamentosRep.findByNome_cliente(novoPedido.getNome_cliente());

        for(Desconto desc : descontos){
            if(desc.aplicavel(itensPedidos, orcamentos)){
                dependentes.add(desc.calculaDesconto(itensPedidos, orcamentos));
            }
        }

        // adquire o maior desconto possivel
        if(dependentes.size() > 0){
            desconto = Collections.max(dependentes);
        }
        
        dependentes = new ArrayList<>();
        for (Imposto i : impostos) {
            if (i.aplicavel(itensPedidos)) {
                dependentes.add(i.calculaImposto(itensPedidos));
            }
        }

        imposto = Collections.max(dependentes);

        totalDaCompra = somaPrecos + (somaPrecos * imposto) - (somaPrecos * desconto);

        novoPedido.setOrcamento(novoOrcamento);

        Pedido ped = pedidosRep.save(novoPedido);
        for(ItemPedido i : itensPedidos){
            i.setPedido(ped);
            itemPedidoRep.save(i);
        }
        
        // return new Orcamento(LocalDate.now(), novoPedido.getNome_cliente(), ped, somaPrecos, imposto, desconto, totalDaCompra);        
        novoOrcamento.setData(LocalDate.now());
        novoOrcamento.setPedido(ped);
        novoOrcamento.setCusto_pedido(somaPrecos);
        novoOrcamento.setImposto(imposto);
        novoOrcamento.setDesconto(desconto);
        novoOrcamento.setTotal_pagar(totalDaCompra);
        return novoOrcamento;
    }

    public Orcamento solicitarOrcamento(Pedido novoPedido, double somaPrecos) throws Exception {
        Orcamento novoOrcamento = geraOrcamento(novoPedido, somaPrecos);
        orcamentosRep.save(novoOrcamento);
        return novoOrcamento;
    }

    public boolean verificaOrcamento(long id) throws Exception {
        if(!orcamentosRep.existsById(id)){
            throw new Exception("O orcamento indicado não existe");
        }
        LocalDate dataOrcamento = orcamentosRep.findById(id).getData();
        LocalDate dataAtual = LocalDate.now();
        long diferencaDias = ChronoUnit.DAYS.between(dataOrcamento, dataAtual);
        
        if (dataOrcamento.getMonthValue() == 1 || dataOrcamento.getMonthValue() == 2) {
            if (diferencaDias > 35)
                return false;
            else
                return true;
        }
        else {
            if (diferencaDias > 21)
                return false;
            else
                return true;
        }
    }

    public Orcamento getOrcamento(long id) {
        return orcamentosRep.findById(id);
    }

    public void atualizaOrcamento(Orcamento orc) {
        orcamentosRep.save(orc);
    }


    public List<Orcamento> getOrcamentos(){
        return orcamentosRep.findAll();
    }
}
