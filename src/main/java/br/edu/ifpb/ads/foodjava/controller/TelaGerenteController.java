package br.edu.ifpb.ads.foodjava.controller;

import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import br.edu.ifpb.ads.foodjava.util.Sessao;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class TelaGerenteController {

    @FXML
    private Button btnCadastrarItem;

    @FXML
    public void abrirCadastroItem() {

        TrocarTela.abrir(
                (Stage) btnCadastrarItem.getScene().getWindow(),
                "CadastroItemCardapio.fxml");

    }

    @FXML
    public void abrirCardapio() {

        TrocarTela.abrir(
                (Stage) btnCadastrarItem.getScene().getWindow(),
                "Cardapio.fxml");

    }

    @FXML
    public void editarRestaurante() {

        TrocarTela.abrir(
                (Stage) btnCadastrarItem.getScene().getWindow(),
                "EditarRestaurante.fxml");

    }
    
    @FXML
    public void abrirPedidos() {

        // módulo 4

    }

    @FXML
    public void sair() {

    	Sessao.limpar();
    	
        TrocarTela.abrir(
                (Stage) btnCadastrarItem.getScene().getWindow(),
                "Login.fxml");

    }

    
    
}