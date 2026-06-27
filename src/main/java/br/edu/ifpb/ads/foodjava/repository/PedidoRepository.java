package br.edu.ifpb.ads.foodjava.repository;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import br.edu.ifpb.ads.foodjava.model.Pedido;
import br.edu.ifpb.ads.foodjava.util.Caminhos;
import br.edu.ifpb.ads.foodjava.util.JsonUtil;

public class PedidoRepository {

    public void salvar(Pedido pedido) {

        List<Pedido> pedidos = listar();

        pedidos.add(pedido);

        JsonUtil.salvar(Caminhos.PEDIDOS, pedidos);

    }

    public List<Pedido> listar() {

        Type tipo = new TypeToken<List<Pedido>>() {}.getType();

        List<Pedido> pedidos = JsonUtil.carregarLista(Caminhos.PEDIDOS, tipo);

        if (pedidos == null) {
            pedidos = new ArrayList<>();
        }

        return pedidos;

    }

    public Pedido buscarPorId(String id) {

        for (Pedido pedido : listar()) {

            if (pedido.getId().equalsIgnoreCase(id)) {
                return pedido;
            }

        }

        return null;

    }

    public void atualizar(Pedido pedidoAtualizado) {

        List<Pedido> pedidos = listar();

        for (int i = 0; i < pedidos.size(); i++) {

            if (pedidos.get(i).getId().equalsIgnoreCase(pedidoAtualizado.getId())) {

                pedidos.set(i, pedidoAtualizado);

                JsonUtil.salvar(Caminhos.PEDIDOS, pedidos);

                return;
            }

        }

    }

    public void remover(Pedido pedido) {

        List<Pedido> pedidos = listar();

        pedidos.removeIf(p -> p.getId().equalsIgnoreCase(pedido.getId()));

        JsonUtil.salvar(Caminhos.PEDIDOS, pedidos);

    }

}