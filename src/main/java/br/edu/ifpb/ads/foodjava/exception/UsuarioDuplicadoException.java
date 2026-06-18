package br.edu.ifpb.ads.foodjava.exception;

public class UsuarioDuplicadoException extends Exception {

    public UsuarioDuplicadoException() {
        super("Já existe um usuário cadastrado com este e-mail.");
    }

}