package br.edu.ifpb.ads.foodjava.exception;

public class ItemVinculadoException extends Exception {

    public ItemVinculadoException() {
        super("Não é possível remover um item que está vinculado.");
    }

}