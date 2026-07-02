package br.edu.ifpb.ads.foodjava.controller;

import java.util.List;

import br.edu.ifpb.ads.foodjava.model.ItemCardapio;
import br.edu.ifpb.ads.foodjava.service.ItemCardapioService;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CardapioGerenteController {

    @FXML
    private TableView<ItemCardapio> tableItens;

    @FXML
    private TableColumn<ItemCardapio, String> colNome;

    @FXML
    private TableColumn<ItemCardapio, String> colCategoria;

    @FXML
    private TableColumn<ItemCardapio, Double> colPreco;

    @FXML
    private TableColumn<ItemCardapio, String> colDisponivel;

    @FXML
    private Button btnVoltar;

    private ItemCardapioService service = new ItemCardapioService();

    @FXML
    public void initialize() {

        colNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));

        colCategoria.setCellValueFactory(
                new PropertyValueFactory<>("categoria"));

        colPreco.setCellValueFactory(
                new PropertyValueFactory<>("preco"));

        colDisponivel.setCellValueFactory(cell ->
        new javafx.beans.property.SimpleStringProperty(
                cell.getValue().isDisponivel()
                        ? "Disponível"
                        : "Indisponível"));

        carregarTabela();

    }

    private void carregarTabela() {

        List<ItemCardapio> itens = service.listarItens();

        tableItens.setItems(
                FXCollections.observableArrayList(itens));

    }

    @FXML
    public void atualizar() {

        carregarTabela();

    }

    @FXML
    public void excluir() {

        ItemCardapio item = tableItens.getSelectionModel().getSelectedItem();

        if (item != null) {

            service.removerItem(item);

            carregarTabela();

        }
    }
        
    @FXML
    public void editar() {

    	ItemCardapio item = tableItens.getSelectionModel().getSelectedItem();

        if(item == null) {
                return;
     }

            service.atualizarItem(item);

    }

    @FXML
    public void voltar() {

        TrocarTela.abrir(
                (Stage) tableItens.getScene().getWindow(),
                "TelaGerente.fxml");

    }

}