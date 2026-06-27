package br.edu.ifpb.ads.foodjava.repository;

import br.edu.ifpb.ads.foodjava.model.Restaurante;
import br.edu.ifpb.ads.foodjava.util.Caminhos;
import br.edu.ifpb.ads.foodjava.util.JsonUtil;

public class RestauranteRepository {

    public void salvar(Restaurante restaurante) {

        JsonUtil.salvar(Caminhos.RESTAURANTE, restaurante);

    }

    public Restaurante buscar() {

        return JsonUtil.carregar(
                Caminhos.RESTAURANTE,
                Restaurante.class);

    }

    public void atualizar(Restaurante restaurante) {

        JsonUtil.salvar(
                Caminhos.RESTAURANTE,
                restaurante);

    }

    public boolean existeRestaurante() {

        return buscar() != null;

    }

}