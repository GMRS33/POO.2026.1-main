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
    private CheckBox ckDisponivel;

    @FXML
    private TextField txtImagem;

    private ItemCardapioService service = new ItemCardapioService();

    @FXML
    public void initialize() {

        cbCategoria.setItems(
                FXCollections.observableArrayList(Categoria.values()));

    }

    @FXML
    public void salvar() {

        try {

            if (txtNome.getText().isBlank()
                    || txtDescricao.getText().isBlank()
                    || txtPreco.getText().isBlank()
                    || cbCategoria.getValue() == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Preencha todos os campos obrigatórios.");
                alert.showAndWait();
                return;

            }

            ItemCardapio item = new ItemCardapio(

                    txtNome.getText(),

                    txtDescricao.getText(),

                    Double.parseDouble(txtPreco.getText()),

                    cbCategoria.getValue(),

                    ckDisponivel.isSelected(),

                    txtImagem.getText()

            );

            service.cadastrarItem(item);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Item cadastrado com sucesso!");
            alert.showAndWait();

            limparCampos();

        } catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Preço inválido.");
            alert.showAndWait();

        }

    }

    private void limparCampos() {

        txtNome.clear();
        txtDescricao.clear();
        txtPreco.clear();
        txtImagem.clear();
        ckDisponivel.setSelected(false);
        cbCategoria.setValue(null);

    }

    @FXML
    public void voltar() {

        TrocarTela.abrir(
                (Stage) txtNome.getScene().getWindow(),
                "TelaGerente.fxml");

    }

}