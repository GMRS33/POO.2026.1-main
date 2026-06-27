package br.edu.ifpb.ads.foodjava.controller;

import br.edu.ifpb.ads.foodjava.model.ItemPedido;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CarrinhoController {

    @FXML
    private TableView<ItemPedido> tableCarrinho;

    @FXML
    private TableColumn<ItemPedido,String> colNome;

    @FXML
    private TableColumn<ItemPedido,Integer> colQuantidade;

    @FXML
    private TableColumn<ItemPedido,Double> colPreco;

    @FXML
    private TableColumn<ItemPedido,Double> colSubtotal;

    @FXML
    private Label lblTotal;

    @FXML
    public void initialize(){

        colNome.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(
                        cell.getValue().getItem().getNome()));

        colQuantidade.setCellValueFactory(
                new PropertyValueFactory<>("quantidade"));

        colPreco.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleObjectProperty<>(
                        cell.getValue().getItem().getPreco()));

        colSubtotal.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleObjectProperty<>(
                        cell.getValue().getSubtotal()));

        atualizarTabela();

    }

    private void atualizarTabela(){

        tableCarrinho.setItems(

                FXCollections.observableArrayList(

                        CardapioClienteController.carrinho.getItens()

                )

        );

        lblTotal.setText(String.format("R$ %.2f",

                CardapioClienteController.carrinho.getValorTotal()

        ));

    }

    @FXML
    public void removerItem(){

        ItemPedido item = tableCarrinho.getSelectionModel().getSelectedItem();

        if(item == null){
            return;
        }

        CardapioClienteController.carrinho.removerItem(item);

        atualizarTabela();

    }

    @FXML
    public void limparCarrinho(){

        CardapioClienteController.carrinho.limpar();

        atualizarTabela();

    }

    @FXML
    public void finalizarPedido(){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText(null);

        alert.setContentText(
                "Implementaremos no Módulo 4.");

        alert.showAndWait();

    }

    @FXML
    public void voltar(){

        TrocarTela.abrir(

                (Stage)tableCarrinho.getScene().getWindow(),

                "TelaCliente.fxml"

        );

    }

}