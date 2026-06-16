package br.edu.ifpb.ads.foodjava.model;

public class ItemPedido {
	private ItemCardapio item;
	private int quantidade;
	
	public ItemPedido(ItemCardapio item, int quantidade) {
		super();
		this.item = item;
		this.quantidade = quantidade;
	}

	public ItemCardapio getItem() {
		return item;
	}

	public void setItem(ItemCardapio item) {
		this.item = item;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
