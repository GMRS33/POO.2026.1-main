package br.edu.ifpb.ads.foodjava.controller;

import java.util.List;

import br.edu.ifpb.ads.foodjava.model.Cliente;
import br.edu.ifpb.ads.foodjava.repository.ClienteRepository;

public class ClienteController {

    private ClienteRepository repository;

    public ClienteController() {
        repository = new ClienteRepository();
    }

    public void cadastrarCliente(Cliente cliente) {
        repository.salvar(cliente);
    }

    public List<Cliente> listarClientes() {
        return repository.listar();
    }

    public void removerCliente(Cliente cliente) {
        repository.remover(cliente);
    }

    public Cliente buscarPorEmail(String email) {
        return repository.buscarPorEmail(email);
    }
}