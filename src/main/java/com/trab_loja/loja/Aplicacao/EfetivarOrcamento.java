package com.trab_loja.loja.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trab_loja.loja.Dominio.Entidades.Orcamento;
import com.trab_loja.loja.Dominio.Servicos.ServicoEstoque;
import com.trab_loja.loja.Dominio.Servicos.ServicoVendas;

@Component
public class EfetivarOrcamento {
    @Autowired
    private ServicoEstoque servicoEstoque;

    @Autowired
    private ServicoVendas servicoVendas;

    public Orcamento run(long id) throws Exception {
        if (servicoVendas.verificaOrcamento(id)) {
            Orcamento aux = servicoVendas.getOrcamento(id);
            if(aux.isEfetivado()){
                throw new Exception("O orcamento indicado já está efetivado");
            }
            aux = servicoEstoque.efetivarOrcamento(aux);

            if(aux == null)
                throw new Exception("O orcamento indicado não existe");
            else
                servicoVendas.atualizaOrcamento(aux);

            return aux;
        } 
        else
            throw new Exception("O orcamento indicado não é mais válido");
    }
}
