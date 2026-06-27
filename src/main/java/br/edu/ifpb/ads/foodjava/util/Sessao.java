package br.edu.ifpb.ads.foodjava.util;

import br.edu.ifpb.ads.foodjava.model.Cliente;
import br.edu.ifpb.ads.foodjava.model.Gerente;

public class Sessao {

    private static Cliente clienteLogado;
    private static Gerente gerenteLogado;

    public static Cliente getClienteLogado() {
        return clienteLogado;
    }

    public static void setClienteLogado(Cliente cliente) {
        clienteLogado = cliente;
    }

    public static Gerente getGerenteLogado() {
        return gerenteLogado;
    }

    public static void setGerenteLogado(Gerente gerente) {
        gerenteLogado = gerente;
    }

    public static void limpar() {
        clienteLogado = null;
        gerenteLogado = null;
    }

}