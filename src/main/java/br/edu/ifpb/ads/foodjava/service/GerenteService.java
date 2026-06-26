package br.edu.ifpb.ads.foodjava.service;

import br.edu.ifpb.ads.foodjava.model.Gerente;
import br.edu.ifpb.ads.foodjava.repository.GerenteRepository;

public class GerenteService {

    private GerenteRepository repository;

    public GerenteService() {
        repository = new GerenteRepository();
    }

    public void cadastrarGerente(Gerente gerente) {
        repository.salvar(gerente);
    }

    public Gerente buscarGerente() {
        return repository.buscar();
    }

    public void atualizarGerente(Gerente gerente) {
        repository.atualizar(gerente);
    }

    public boolean gerenteExiste() {
        return repository.existeGerente();
    }

}