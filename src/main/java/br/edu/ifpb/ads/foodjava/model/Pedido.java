package br.edu.ifpb.ads.foodjava.model;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
	private String id;
	private LocalDateTime dataHora;
	private List<ItemPedido> itens;
	private double valorTotal;
	private StatusPedido status;
	
	public Pedido(String id, LocalDateTime dataHora, List<ItemPedido> itens, double valorTotal, StatusPedido status) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.itens = itens;
		this.valorTotal = valorTotal;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	
}
