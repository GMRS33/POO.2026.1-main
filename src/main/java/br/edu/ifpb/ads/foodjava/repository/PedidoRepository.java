package br.edu.ifpb.ads.foodjava.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.ads.foodjava.model.Pedido;

public class PedidoRepository {

    private List<Pedido> pedidos;

    public PedidoRepository() {
        pedidos = new ArrayList<>();
    }

    public void salvar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> listar() {
        return pedidos;
    }

    public void remover(Pedido pedido) {
        pedidos.remove(pedido);
    }
    
    public Pedido buscarPorId(String id) {

        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(id)) {
                return pedido;
            }
        }

        return null;
    }
}