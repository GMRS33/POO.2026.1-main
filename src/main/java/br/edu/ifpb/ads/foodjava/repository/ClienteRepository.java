package br.edu.ifpb.ads.foodjava.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.ads.foodjava.model.Cliente;

public class ClienteRepository {

    private List<Cliente> clientes;

    public ClienteRepository() {
        clientes = new ArrayList<>();
    }

    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public List<Cliente> listar() {
        return clientes;
    }
    
    public void remover(Cliente cliente) {
        clientes.remove(cliente);
    }
    
    public Cliente buscarPorEmail(String email) {

        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email)) {
                return cliente;
            }
        }

        return null;
    }
    
}