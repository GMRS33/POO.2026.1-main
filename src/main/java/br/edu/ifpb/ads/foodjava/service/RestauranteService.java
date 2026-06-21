package br.edu.ifpb.ads.foodjava.service;

import java.util.List;

import br.edu.ifpb.ads.foodjava.exception.UsuarioDuplicadoException;
import br.edu.ifpb.ads.foodjava.model.Restaurante;
import br.edu.ifpb.ads.foodjava.repository.RestauranteRepository;

public class RestauranteService {

    private RestauranteRepository repository;

    public RestauranteService() {
        repository = new RestauranteRepository();
    }

    public void cadastrarRestaurante(Restaurante restaurante) throws UsuarioDuplicadoException {

        if (repository.buscarPorEmail(restaurante.getEmail()) != null) {
            throw new UsuarioDuplicadoException();
        }

        repository.salvar(restaurante);
    }

    public List<Restaurante> listarRestaurantes() {
        return repository.listar();
    }

    public Restaurante buscarRestaurante(String email) {
        return repository.buscarPorEmail(email);
    }

    public void removerRestaurante(Restaurante restaurante) {
        repository.remover(restaurante);
    }
}