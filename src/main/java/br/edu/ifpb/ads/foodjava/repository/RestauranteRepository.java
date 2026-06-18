package br.edu.ifpb.ads.foodjava.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.ads.foodjava.model.Restaurante;

public class RestauranteRepository {

    private List<Restaurante> restaurantes;

    public RestauranteRepository() {
        restaurantes = new ArrayList<>();
    }

    public void salvar(Restaurante restaurante) {
        restaurantes.add(restaurante);
    }

    public List<Restaurante> listar() {
        return restaurantes;
    }

    public void remover(Restaurante restaurante) {
        restaurantes.remove(restaurante);
    }
}