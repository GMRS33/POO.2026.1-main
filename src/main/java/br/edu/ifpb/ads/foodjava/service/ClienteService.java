package br.edu.ifpb.ads.foodjava.service;

import java.util.List;

import br.edu.ifpb.ads.foodjava.exception.SenhaInvalidaException;
import br.edu.ifpb.ads.foodjava.exception.UsuarioDuplicadoException;
import br.edu.ifpb.ads.foodjava.model.Cliente;
import br.edu.ifpb.ads.foodjava.model.Gerente;
import br.edu.ifpb.ads.foodjava.repository.ClienteRepository;

public class ClienteService {

    private ClienteRepository repository;

    public ClienteService() {
        repository = new ClienteRepository();
    }

    public void cadastrarCliente(Cliente cliente) throws UsuarioDuplicadoException {

        if (repository.buscarPorEmail(cliente.getEmail()) != null) {
            throw new UsuarioDuplicadoException();
        }

        GerenteService gerenteService = new GerenteService();

        Gerente gerente = gerenteService.buscarGerente();

        if (gerente != null &&
            gerente.getEmail().equalsIgnoreCase(cliente.getEmail())) {

            throw new UsuarioDuplicadoException();   
    }
        
        
        repository.salvar(cliente);
    }

    public List<Cliente> listarClientes() {
        return repository.listar();
    }

    public Cliente buscarCliente(String email) {
        return repository.buscarPorEmail(email);
    }

    public void removerCliente(Cliente cliente) {
        repository.remover(cliente);
    }
    
    public Cliente login(String email, String senha) throws SenhaInvalidaException {

        Cliente cliente = repository.buscarPorEmail(email);

        if (cliente == null) {
            return null;
        }

        if (!cliente.getSenha().equals(senha)) {
            throw new SenhaInvalidaException();
        }

        return cliente;
    }
}