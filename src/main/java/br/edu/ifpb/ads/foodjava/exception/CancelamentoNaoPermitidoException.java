package br.edu.ifpb.ads.foodjava.exception;

public class CancelamentoNaoPermitidoException extends Exception {

    public CancelamentoNaoPermitidoException() {
        super("Este pedido não pode mais ser cancelado.");
    }

}