package br.edu.ifpb.ads.foodjava.exception;

public class StatusInvalidoException extends Exception {

    public StatusInvalidoException() {
        super("Status inválido para esta operação.");
    }

}