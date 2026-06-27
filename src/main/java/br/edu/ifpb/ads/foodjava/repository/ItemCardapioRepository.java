package br.edu.ifpb.ads.foodjava.repository;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import br.edu.ifpb.ads.foodjava.model.ItemCardapio;
import br.edu.ifpb.ads.foodjava.util.Caminhos;
import br.edu.ifpb.ads.foodjava.util.JsonUtil;

public class ItemCardapioRepository {

    public void salvar(ItemCardapio item) {

        List<ItemCardapio> itens = listar();

        itens.add(item);

        JsonUtil.salvar(Caminhos.CARDAPIO, itens);

    }

    public List<ItemCardapio> listar() {

        Type tipo = new TypeToken<List<ItemCardapio>>() {}.getType();

        List<ItemCardapio> itens = JsonUtil.carregarLista(Caminhos.CARDAPIO, tipo);

        if (itens == null) {
            itens = new ArrayList<>();
        }

        return itens;

    }

    public ItemCardapio buscarPorNome(String nome) {

        for (ItemCardapio item : listar()) {

            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }

        }

        return null;

    }

    public void atualizar(ItemCardapio itemAtualizado) {

        List<ItemCardapio> itens = listar();

        for (int i = 0; i < itens.size(); i++) {

            if (itens.get(i).getNome().equalsIgnoreCase(itemAtualizado.getNome())) {

                itens.set(i, itemAtualizado);

                JsonUtil.salvar(Caminhos.CARDAPIO, itens);

                return;
            }

        }

    }

    public void remover(ItemCardapio item) {

        List<ItemCardapio> itens = listar();

        itens.removeIf(i -> i.getNome().equalsIgnoreCase(item.getNome()));

        JsonUtil.salvar(Caminhos.CARDAPIO, itens);

    }

}