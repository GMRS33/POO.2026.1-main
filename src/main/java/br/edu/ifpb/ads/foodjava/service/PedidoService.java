package br.edu.ifpb.ads.foodjava.service;

import java.util.List;

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

    public Pedido buscarPedido(String id) {
        return repository.buscarPorId(id);
    }

    public void removerPedido(Pedido pedido) {
        repository.remover(pedido);
    }
}