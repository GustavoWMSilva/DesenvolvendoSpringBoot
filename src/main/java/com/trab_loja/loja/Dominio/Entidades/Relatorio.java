package com.trab_loja.loja.Dominio.Entidades;

import java.util.List;

public class Relatorio {

    private List<Orcamento> orcamentos;

    public Relatorio (List <Orcamento> orcamentos) {
        this.orcamentos = orcamentos.stream()
                                    .filter(p -> p.isEfetivado())
                                    .toList();
    }

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    @Override
    public String toString() {
        return "Relatorio [orcamentos=" + orcamentos + "]";
    }
}
