package br.edu.ifpb.ads.foodjava.controller;

import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import br.edu.ifpb.ads.foodjava.util.Sessao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaClienteController {

    @FXML
    private Button btnCardapio;

    @FXML
    public void abrirCardapio() {

        TrocarTela.abrir(
                (Stage) btnCardapio.getScene().getWindow(),
                "CardapioCliente.fxml");

    }

    @FXML
    public void abrirCarrinho() {

        TrocarTela.abrir(
                (Stage) btnCardapio.getScene().getWindow(),
                "Carrinho.fxml");

    }

    @FXML
    public void abrirPedidos() {

        // será implementado no módulo 4

    }

    @FXML
    public void sair() {

    	Sessao.limpar();
    	
        TrocarTela.abrir(
                (Stage) btnCardapio.getScene().getWindow(),
                "Login.fxml");

    }

}