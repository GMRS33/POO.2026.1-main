package br.edu.ifpb.ads.foodjava.service;

import java.util.List;

import br.edu.ifpb.ads.foodjava.model.ItemCardapio;
import br.edu.ifpb.ads.foodjava.repository.ItemCardapioRepository;

public class ItemCardapioService {

    private ItemCardapioRepository repository;

    public ItemCardapioService() {
        repository = new ItemCardapioRepository();
    }

    public void cadastrarItem(ItemCardapio item) {
        repository.salvar(item);
    }

    public List<ItemCardapio> listarItens() {
        return repository.listar();
    }

    public ItemCardapio buscarItem(String nome) {
        return repository.buscarPorNome(nome);
    }

    public void removerItem(ItemCardapio item) {
        repository.remover(item);
    }
}