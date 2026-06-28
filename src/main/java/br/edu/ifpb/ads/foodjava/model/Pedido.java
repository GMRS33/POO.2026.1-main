package br.edu.ifpb.ads.foodjava.model;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    private String id;
    private Cliente cliente;
    private LocalDateTime dataHora;
    private List<ItemPedido> itens;
    private double valorTotal;
    private StatusPedido status;

    public Pedido(String id,
                  Cliente cliente,
                  LocalDateTime dataHora,
                  List<ItemPedido> itens,
                  double valorTotal,
                  StatusPedido status) {

        this.id = id;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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