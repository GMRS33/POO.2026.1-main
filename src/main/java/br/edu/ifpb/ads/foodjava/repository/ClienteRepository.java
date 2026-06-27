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

	    System.out.println("===== SALVAR =====");
	    System.out.println("Nome: " + cliente.getNome());

	    List<Cliente> clientes = listar();

	    System.out.println("Clientes antes: " + clientes.size());

	    clientes.add(cliente);

	    System.out.println("Clientes depois: " + clientes.size());

	    JsonUtil.salvar(Caminhos.CLIENTES, clientes);

	    System.out.println("Arquivo salvo!");

	}

    public List<Cliente> listar() {

        Type tipo = new TypeToken<List<Cliente>>() {
        }.getType();

        List<Cliente> clientes =
                JsonUtil.carregarLista(Caminhos.CLIENTES, tipo);

        if (clientes == null) {
            clientes = new ArrayList<>();
        }

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