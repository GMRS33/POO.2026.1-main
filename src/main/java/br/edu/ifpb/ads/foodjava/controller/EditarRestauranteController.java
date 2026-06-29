package br.edu.ifpb.ads.foodjava.controller;

import br.edu.ifpb.ads.foodjava.model.Restaurante;
import br.edu.ifpb.ads.foodjava.service.RestauranteService;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import br.edu.ifpb.ads.foodjava.util.Validacao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarRestauranteController {

    @FXML
    private TextField txtNomeFantasia;

    @FXML
    private TextField txtCnpj;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtEmail;

    private RestauranteService service = new RestauranteService();

    @FXML
    public void initialize() {

        Restaurante restaurante = service.buscarRestaurante();

        if (restaurante != null) {

            txtNomeFantasia.setText(restaurante.getNomeFantasia());
            txtCnpj.setText(restaurante.getCnpj());
            txtEndereco.setText(restaurante.getEndereco());
            txtTelefone.setText(restaurante.getTelefone());
            txtCategoria.setText(restaurante.getCategoriaCulinaria());
            txtEmail.setText(restaurante.getEmail());

        }

    }

    @FXML
    public void salvar() {

        if (Validacao.campoVazio(txtNomeFantasia.getText())
                || Validacao.campoVazio(txtEndereco.getText())
                || Validacao.campoVazio(txtCategoria.getText())
                || Validacao.campoVazio(txtEmail.getText())) {

            mostrarAviso("Preencha todos os campos.");
            return;

        }

        if (!Validacao.cnpjValido(txtCnpj.getText())) {

            mostrarAviso("CNPJ inválido.");
            return;

        }

        if (!Validacao.telefoneValido(txtTelefone.getText())) {

            mostrarAviso("Telefone inválido.");
            return;

        }

        if (!Validacao.emailValido(txtEmail.getText())) {

            mostrarAviso("E-mail inválido.");
            return;

        }

        Restaurante restaurante = new Restaurante(

                txtNomeFantasia.getText(),
                txtCnpj.getText(),
                txtEndereco.getText(),
                txtTelefone.getText(),
                txtCategoria.getText(),
                txtEmail.getText()

        );

        service.atualizarRestaurante(restaurante);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Restaurante atualizado com sucesso!");
        alert.showAndWait();

    }

    @FXML
    public void voltar() {

        TrocarTela.abrir(
                (Stage) txtNomeFantasia.getScene().getWindow(),
                "TelaGerente.fxml");

    }

    private void mostrarAviso(String mensagem) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();

    }

}