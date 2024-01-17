package com.trab_loja.loja.Interface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trab_loja.loja.Aplicacao.EfetivarOrcamento;
import com.trab_loja.loja.Aplicacao.GerarRelatorio;
import com.trab_loja.loja.Aplicacao.ProdutosDisponiveis_UC;
import com.trab_loja.loja.Aplicacao.SolicitarOrcamento;
import com.trab_loja.loja.Dominio.Entidades.ItemPedido;
import com.trab_loja.loja.Dominio.Entidades.Orcamento;
import com.trab_loja.loja.Dominio.Entidades.Pedido;
import com.trab_loja.loja.Dominio.Entidades.Produto;


@RestController
public class Controller {
    @Autowired
    private ProdutosDisponiveis_UC produtosDisponiveis_UC;

    @Autowired
    private EfetivarOrcamento efetivarOrcamento;

    @Autowired
    private SolicitarOrcamento solicitarOrcamento;

    @Autowired
    private GerarRelatorio gerarRelatorio;


    @GetMapping("")
    @CrossOrigin("*")
    public String homepage() {
        return "Bem-vindo(a)";
    }

    @GetMapping("produtosDisponiveis")
    @CrossOrigin("*")
    public List<Produto> produtosDisponiveis() {
        return produtosDisponiveis_UC.run();
    }

    @PostMapping("solicitarOrcamento/{nome}")
    @CrossOrigin("*")
    public Orcamento solicitarOrcamento(@PathVariable(value="nome") String nome, @RequestBody final List<ItemPedido> pedidos) throws Exception{
        Pedido novoPedido = new Pedido(nome, pedidos);
        return solicitarOrcamento.run(novoPedido);
    }

    @GetMapping("efetivarOrcamento/{id}")
    @CrossOrigin("*")
    public Orcamento efetivarOrcamento(@PathVariable(value="id") long id) throws Exception {
        return efetivarOrcamento.run(id);
    }

    @GetMapping("gerarRelatorio/{nome}")
    @CrossOrigin("*")
    public String gerarRelatorio(@PathVariable(value="nome") String nome) {
        return gerarRelatorio.run(nome);
    }
}
