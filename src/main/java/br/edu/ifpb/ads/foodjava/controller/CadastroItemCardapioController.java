package br.edu.ifpb.ads.foodjava.controller;

import br.edu.ifpb.ads.foodjava.model.Categoria;
import br.edu.ifpb.ads.foodjava.model.ItemCardapio;
import br.edu.ifpb.ads.foodjava.service.ItemCardapioService;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import br.edu.ifpb.ads.foodjava.util.Validacao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroItemCardapioController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtDescricao;

    @FXML
    private TextField txtPreco;

    @FXML
    private ComboBox<Categoria> cbCategoria;

    @FXML
    private TextField txtImagem;

    private ItemCardapioService service = new ItemCardapioService();

    @FXML
    public void initialize() {

        cbCategoria.setItems(
                FXCollections.observableArrayList(Categoria.values()));

    }

    @FXML
    public void cadastrar() {

        if (Validacao.campoVazio(txtNome.getText())
                || Validacao.campoVazio(txtDescricao.getText())
                || Validacao.campoVazio(txtPreco.getText())
                || cbCategoria.getValue() == null) {

            mostrarAviso("Preencha todos os campos.");
            return;
        }

        double preco;

        try {

            preco = Double.parseDouble(txtPreco.getText().replace(",", "."));

        } catch (NumberFormatException e) {

            mostrarAviso("Preço inválido.");
            return;
        }

        if (!Validacao.precoValido(preco)) {

            mostrarAviso("O preço deve ser maior que zero.");
            return;
        }

        ItemCardapio item = new ItemCardapio(

                txtNome.getText(),
                txtDescricao.getText(),
                preco,
                cbCategoria.getValue(),
                true,
                txtImagem.getText()

        );

        service.cadastrarItem(item);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Item cadastrado com sucesso!");
        alert.showAndWait();

        limparCampos();

    }

    private void limparCampos() {

        txtNome.clear();
        txtDescricao.clear();
        txtPreco.clear();
        txtImagem.clear();
        cbCategoria.getSelectionModel().clearSelection();

    }

    private void mostrarAviso(String mensagem) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();

    }

    @FXML
    public void voltar() {

        TrocarTela.abrir(
                (Stage) txtNome.getScene().getWindow(),
                "TelaGerente.fxml");

    }

}