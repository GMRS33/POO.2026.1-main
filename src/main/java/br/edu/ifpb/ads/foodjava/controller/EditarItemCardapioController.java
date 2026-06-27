package br.edu.ifpb.ads.foodjava.controller;

import br.edu.ifpb.ads.foodjava.model.Categoria;
import br.edu.ifpb.ads.foodjava.model.ItemCardapio;
import br.edu.ifpb.ads.foodjava.service.ItemCardapioService;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarItemCardapioController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtDescricao;

    @FXML
    private TextField txtPreco;

    @FXML
    private ComboBox<Categoria> cbCategoria;

    @FXML
    private CheckBox ckDisponivel;

    @FXML
    private TextField txtImagem;

    private ItemCardapioService service = new ItemCardapioService();

    private ItemCardapio item;

    @FXML
    public void initialize() {

        cbCategoria.setItems(
                FXCollections.observableArrayList(Categoria.values()));

    }

    public void carregarItem(ItemCardapio item) {

        this.item = item;

        txtNome.setText(item.getNome());
        txtDescricao.setText(item.getDescricao());
        txtPreco.setText(String.valueOf(item.getPreco()));
        cbCategoria.setValue(item.getCategoria());
        ckDisponivel.setSelected(item.isDisponivel());
        txtImagem.setText(item.getImagemPath());

    }

    @FXML
    public void salvar() {

        item.setNome(txtNome.getText());
        item.setDescricao(txtDescricao.getText());
        item.setPreco(Double.parseDouble(txtPreco.getText()));
        item.setCategoria(cbCategoria.getValue());
        item.setDisponivel(ckDisponivel.isSelected());
        item.setImagemPath(txtImagem.getText());

        service.atualizarItem(item);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Item atualizado com sucesso.");
        alert.showAndWait();

        voltar();

    }

    @FXML
    public void voltar() {

        TrocarTela.abrir(
                (Stage) txtNome.getScene().getWindow(),
                "Cardapio.fxml");

    }

}