package br.edu.ifpb.ads.foodjava.controller;

import java.util.List;

import br.edu.ifpb.ads.foodjava.model.ItemCardapio;
import br.edu.ifpb.ads.foodjava.repository.ItemCardapioRepository;

public class ItemCardapioController {

    private ItemCardapioRepository repository;

    public ItemCardapioController() {
        repository = new ItemCardapioRepository();
    }

    public void cadastrarItem(ItemCardapio item) {
        repository.salvar(item);
    }

    public List<ItemCardapio> listarItens() {
        return repository.listar();
    }

    public void removerItem(ItemCardapio item) {
        repository.remover(item);
    }
}