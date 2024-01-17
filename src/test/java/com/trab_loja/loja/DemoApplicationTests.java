package com.trab_loja.loja;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.trab_loja.loja.Aplicacao.SolicitarOrcamento;
import com.trab_loja.loja.Dominio.Entidades.ItemPedido;
import com.trab_loja.loja.Dominio.Entidades.Orcamento;
import com.trab_loja.loja.Dominio.Entidades.Pedido;
import com.trab_loja.loja.Dominio.Repositorios.IRepItemDeEstoque;
import com.trab_loja.loja.Dominio.Repositorios.IRepItemPedido;
import com.trab_loja.loja.Dominio.Repositorios.IRepOrcamentos;
import com.trab_loja.loja.Dominio.Repositorios.IRepPedidos;
import com.trab_loja.loja.Dominio.Repositorios.IRepProdutos;
import com.trab_loja.loja.Dominio.Servicos.ServicoEstoque;
import com.trab_loja.loja.Dominio.Servicos.ServicoVendas;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	IRepOrcamentos orcamentosRep;
	@Autowired
	IRepPedidos pedidosRep;
	@Autowired
	IRepItemPedido itemPedRep;
	@Autowired
	IRepItemDeEstoque estoqueRep;
	@Autowired 
	IRepProdutos produtosRep;
	@Autowired
	SolicitarOrcamento solicitarOrcamento;

	private ServicoVendas vendas;
	private ServicoEstoque estoque;
	@BeforeEach
	void contextLoads() {
		this.vendas = new ServicoVendas(orcamentosRep, pedidosRep, itemPedRep);
		
		this.estoque = new ServicoEstoque(produtosRep, estoqueRep);
	}

	@Test
	public void testDescontoPadrao() throws Exception {
		LinkedList<ItemPedido> pedidos = new LinkedList();
		pedidos.add(new ItemPedido(8, 50));
		
		Pedido ped = new Pedido("NomeTesteUnitario", pedidos);

		double preco = estoque.calcSomatorioPrecos(ped);
		

		Orcamento teste = vendas.geraOrcamento(ped, preco);

		double descontoEsperado = 0.05;
		double resultado = teste.getDesconto();

		itemPedRep.deleteById(pedidos.get(0).getItem_pedido_id());
		pedidosRep.deleteById(ped.getPed_id());
		orcamentosRep.deleteById(teste.getid_orc());

		Assertions.assertEquals(descontoEsperado, resultado);
	}

	@Test
	public void testDescontoMaisDeDez() throws Exception {
		LinkedList<ItemPedido> pedidos = new LinkedList();
		pedidos.add(new ItemPedido(8, 50));
		
		Pedido ped = new Pedido("ClienteTeste", pedidos);

		double preco = estoque.calcSomatorioPrecos(ped);
		
		Orcamento teste = vendas.geraOrcamento(ped, preco);

		double descontoEsperado = 0.25;
		double resultado = teste.getDesconto();

		itemPedRep.deleteById(pedidos.get(0).getItem_pedido_id());
		pedidosRep.deleteById(ped.getPed_id());
		orcamentosRep.deleteById(teste.getid_orc());

		Assertions.assertEquals(descontoEsperado, resultado); 
	}
}
