package br.edu.ifpb.ads.foodjava.service;

import br.edu.ifpb.ads.foodjava.model.Restaurante;
import br.edu.ifpb.ads.foodjava.repository.RestauranteRepository;

public class RestauranteService {

    private RestauranteRepository repository;

    public RestauranteService() {
        repository = new RestauranteRepository();
    }

    public void configurarRestaurante(Restaurante restaurante) {

        repository.salvar(restaurante);

    }

    public Restaurante buscarRestaurante() {

        return repository.buscar();

    }

    public void atualizarRestaurante(Restaurante restaurante) {

        repository.atualizar(restaurante);

    }

    public boolean restauranteExiste() {

        return repository.existeRestaurante();

    }

    
    
}