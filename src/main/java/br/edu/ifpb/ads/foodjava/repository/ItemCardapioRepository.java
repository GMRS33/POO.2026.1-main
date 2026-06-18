package br.edu.ifpb.ads.foodjava.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.ads.foodjava.model.ItemCardapio;

public class ItemCardapioRepository {

    private List<ItemCardapio> itens;

    public ItemCardapioRepository() {
        itens = new ArrayList<>();
    }

    public void salvar(ItemCardapio item) {
        itens.add(item);
    }

    public List<ItemCardapio> listar() {
        return itens;
    }

    public void remover(ItemCardapio item) {
        itens.remove(item);
    }
}