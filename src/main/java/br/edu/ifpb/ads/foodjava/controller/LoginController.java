package br.edu.ifpb.ads.foodjava.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void entrar(ActionEvent event) {
        System.out.println("Botão Entrar clicado");
    }

    @FXML
    private void abrirCadastroCliente(ActionEvent event) {
        System.out.println("Abrir cadastro de cliente");
    }

    @FXML
    private void abrirCadastroRestaurante(ActionEvent event) {
        System.out.println("Abrir cadastro de restaurante");
    }
}