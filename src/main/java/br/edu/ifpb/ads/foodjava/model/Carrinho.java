package br.edu.ifpb.ads.foodjava.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<ItemPedido> itens;

    public Carrinho() {
        itens = new ArrayList<>();
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(ItemCardapio item, int quantidade) {

        for (ItemPedido itemPedido : itens) {

            if (itemPedido.getItem().getNome().equalsIgnoreCase(item.getNome())) {

                itemPedido.setQuantidade(
                        itemPedido.getQuantidade() + quantidade);

                return;

            }

        }

        itens.add(new ItemPedido(item, quantidade));

    }

    public void removerItem(ItemPedido itemPedido) {

        itens.remove(itemPedido);

    }

    public void limpar() {

        itens.clear();

    }

    public double getValorTotal() {

        double total = 0;

        for (ItemPedido item : itens) {

            total += item.getSubtotal();

        }

        return total;

    }

}