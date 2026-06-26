package br.edu.ifpb.ads.foodjava.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CadastroClienteController {

    @FXML
    private void salvar(ActionEvent event) {

        System.out.println("Cliente salvo.");

    }

    @FXML
    private void voltar(ActionEvent event) {

        System.out.println("Voltando para Login.");

    }

}