package br.edu.ifpb.ads.foodjava.controller;

import java.util.List;

import br.edu.ifpb.ads.foodjava.model.Restaurante;
import br.edu.ifpb.ads.foodjava.repository.RestauranteRepository;

public class RestauranteController {

    private RestauranteRepository repository;

    public RestauranteController() {
        repository = new RestauranteRepository();
    }

    public void cadastrarRestaurante(Restaurante restaurante) {
        repository.salvar(restaurante);
    }

    public List<Restaurante> listarRestaurantes() {
        return repository.listar();
    }

    public void removerRestaurante(Restaurante restaurante) {
        repository.remover(restaurante);
    }
}