package br.edu.ifpb.ads.foodjava.controller;

import java.util.List;

import br.edu.ifpb.ads.foodjava.model.Carrinho;
import br.edu.ifpb.ads.foodjava.model.ItemCardapio;
import br.edu.ifpb.ads.foodjava.service.ItemCardapioService;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CardapioClienteController {

    @FXML
    private TableView<ItemCardapio> tableItens;

    @FXML
    private TableColumn<ItemCardapio,String> colNome;

    @FXML
    private TableColumn<ItemCardapio,String> colDescricao;

    @FXML
    private TableColumn<ItemCardapio,String> colCategoria;

    @FXML
    private TableColumn<ItemCardapio,Double> colPreco;

    @FXML
    private TableColumn<ItemCardapio,Boolean> colDisponivel;

    private ItemCardapioService service = new ItemCardapioService();

    /*
     * Temporário.
     * No módulo 4 vamos transformar isso em um carrinho do usuário logado.
     */
    public static Carrinho carrinho = new Carrinho();

    @FXML
    public void initialize(){

        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colDisponivel.setCellValueFactory(new PropertyValueFactory<>("disponivel"));

        List<ItemCardapio> itens = service.listarItens();

        tableItens.setItems(FXCollections.observableArrayList(itens));

    }

    @FXML
    public void adicionarCarrinho(){

        ItemCardapio item = tableItens.getSelectionModel().getSelectedItem();

        if(item == null){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Selecione um item.");
            alert.showAndWait();
            return;

        }

        carrinho.adicionarItem(item);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Item adicionado ao carrinho.");
        alert.showAndWait();

    }

    @FXML
    public void voltar(){

        TrocarTela.abrir(
                (Stage)tableItens.getScene().getWindow(),
                "TelaCliente.fxml");

    }

}