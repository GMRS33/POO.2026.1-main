package br.edu.ifpb.ads.foodjava.service;

import java.util.List;

import br.edu.ifpb.ads.foodjava.model.Cliente;
import br.edu.ifpb.ads.foodjava.model.Pedido;
import br.edu.ifpb.ads.foodjava.repository.PedidoRepository;

public class PedidoService {

    private PedidoRepository repository;

    public PedidoService() {

        repository = new PedidoRepository();

    }

    public void cadastrarPedido(Pedido pedido) {

        repository.salvar(pedido);

    }

    public List<Pedido> listarPedidos() {

        return repository.listar();

    }

    public List<Pedido> listarPedidosCliente(Cliente cliente) {

        return repository.buscarPorCliente(cliente);

    }

    public Pedido buscarPedido(String id) {

        return repository.buscarPorId(id);

    }

    public void atualizarPedido(Pedido pedido) {

        repository.atualizar(pedido);

    }

    public void removerPedido(Pedido pedido) {

        repository.remover(pedido);

    }

}