package br.edu.ifpb.ads.foodjava.repository;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import br.edu.ifpb.ads.foodjava.model.Cliente;
import br.edu.ifpb.ads.foodjava.util.Caminhos;
import br.edu.ifpb.ads.foodjava.util.JsonUtil;

public class ClienteRepository {

    public void salvar(Cliente cliente) {

        List<Cliente> clientes = listar();

        clientes.add(cliente);

        JsonUtil.salvar(Caminhos.CLIENTES, clientes);

    }

    @SuppressWarnings("unchecked")
    public List<Cliente> listar() {

    	Type tipo = new TypeToken<List<Cliente>>(){}.getType();

    	List<Cliente> clientes =
    	        JsonUtil.carregarLista(Caminhos.CLIENTES, tipo);

        return clientes;

    }

    public void remover(Cliente cliente) {

        List<Cliente> clientes = listar();

        clientes.remove(cliente);

        JsonUtil.salvar(Caminhos.CLIENTES, clientes);

    }

    public Cliente buscarPorEmail(String email) {

        for (Cliente cliente : listar()) {

            if (cliente.getEmail().equalsIgnoreCase(email)) {

                return cliente;

            }

        }

        return null;

    }

}