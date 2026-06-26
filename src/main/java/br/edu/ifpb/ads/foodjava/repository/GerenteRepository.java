package br.edu.ifpb.ads.foodjava.repository;

import br.edu.ifpb.ads.foodjava.model.Gerente;
import br.edu.ifpb.ads.foodjava.util.Caminhos;
import br.edu.ifpb.ads.foodjava.util.JsonUtil;

public class GerenteRepository {

    public void salvar(Gerente gerente) {

        JsonUtil.salvar(Caminhos.GERENTE, gerente);

    }

    public Gerente buscar() {

        return JsonUtil.carregar(Caminhos.GERENTE, Gerente.class);

    }

    public void atualizar(Gerente gerente) {

        JsonUtil.salvar(Caminhos.GERENTE, gerente);

    }

    public boolean existeGerente() {

        return buscar() != null;

    }

}