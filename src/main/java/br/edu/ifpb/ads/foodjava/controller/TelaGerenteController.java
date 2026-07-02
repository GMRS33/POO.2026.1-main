package br.edu.ifpb.ads.foodjava.controller;

import br.edu.ifpb.ads.foodjava.util.Sessao;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaGerenteController {

    @FXML
    private Button btnCadastrarItem;

    @FXML
    private Button btnCardapio;

    @FXML
    private Button btnRestaurante;

    @FXML
    private Button btnPedidos;

    @FXML
    private Button btnSair;

    @FXML
    public void abrirCadastroItem() {

        TrocarTela.abrir(
                (Stage) btnCadastrarItem.getScene().getWindow(),
                "CadastroItemCardapio.fxml");

    }

    @FXML
    public void abrirCardapio() {

        TrocarTela.abrir(
                (Stage) btnCardapio.getScene().getWindow(),
        		"CardapioGerente.fxml");

    }

    @FXML
    public void editarRestaurante() {

        TrocarTela.abrir(
                (Stage) btnRestaurante.getScene().getWindow(),
                "EditarRestaurante.fxml");

    }

    @FXML
    public void abrirPedidos() {

        TrocarTela.abrir(
                (Stage) btnPedidos.getScene().getWindow(),
                "PedidosGerente.fxml");

    }

    @FXML
    public void sair() {

        Sessao.limpar();

        TrocarTela.abrir(
                (Stage) btnSair.getScene().getWindow(),
                "Login.fxml");

    }

}