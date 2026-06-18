package br.edu.ifpb.ads.foodjava.controller;

import java.util.List;

import br.edu.ifpb.ads.foodjava.model.Pedido;
import br.edu.ifpb.ads.foodjava.repository.PedidoRepository;

public class PedidoController {

    private PedidoRepository repository;

    public PedidoController() {
        repository = new PedidoRepository();
    }

    public void cadastrarPedido(Pedido pedido) {
        repository.salvar(pedido);
    }

    public List<Pedido> listarPedidos() {
        return repository.listar();
    }

    public void removerPedido(Pedido pedido) {
        repository.remover(pedido);
    }
}