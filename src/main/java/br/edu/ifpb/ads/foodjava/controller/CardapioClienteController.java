package br.edu.ifpb.ads.foodjava.controller;

import java.util.List;

import br.edu.ifpb.ads.foodjava.model.Carrinho;
import br.edu.ifpb.ads.foodjava.model.ItemCardapio;
import br.edu.ifpb.ads.foodjava.service.ItemCardapioService;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CardapioClienteController {

    @FXML
    private TableView<ItemCardapio> tableItens;

    @FXML
    private TableColumn<ItemCardapio, String> colNome;

    @FXML
    private TableColumn<ItemCardapio, String> colDescricao;

    @FXML
    private TableColumn<ItemCardapio, String> colCategoria;

    @FXML
    private TableColumn<ItemCardapio, Double> colPreco;

    @FXML
    private TableColumn<ItemCardapio, String> colDisponivel;
    
    @FXML
    private Spinner<Integer> spinnerQuantidade;

    private ItemCardapioService service = new ItemCardapioService();

    public static Carrinho carrinho = new Carrinho();

    @FXML
    public void initialize() {

        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colDisponivel.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(
                cell.getValue().isDisponivel() ? "Disponível" : "Indisponível"
        ));

        List<ItemCardapio> itens = service.listarItens();

        tableItens.setItems(FXCollections.observableArrayList(itens));

        spinnerQuantidade.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99, 1));

    }

    @FXML
    public void adicionarCarrinho() {

        ItemCardapio item = tableItens.getSelectionModel().getSelectedItem();

        if (item == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Selecione um item.");
            alert.showAndWait();
            return;

        }

        int quantidade = spinnerQuantidade.getValue();

        carrinho.adicionarItem(item, quantidade);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(quantidade + " unidade(s) adicionada(s) ao carrinho.");
        alert.showAndWait();

        spinnerQuantidade.getValueFactory().setValue(1);

    }

    @FXML
    public void voltar() {

        TrocarTela.abrir(
                (Stage) tableItens.getScene().getWindow(),
                "TelaCliente.fxml");

    }

}