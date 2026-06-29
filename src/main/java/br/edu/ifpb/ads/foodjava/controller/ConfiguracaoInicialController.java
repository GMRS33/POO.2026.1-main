package br.edu.ifpb.ads.foodjava.controller;

import br.edu.ifpb.ads.foodjava.model.Gerente;
import br.edu.ifpb.ads.foodjava.model.Restaurante;
import br.edu.ifpb.ads.foodjava.service.GerenteService;
import br.edu.ifpb.ads.foodjava.service.RestauranteService;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import br.edu.ifpb.ads.foodjava.util.Validacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConfiguracaoInicialController {

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
    private TextField txtNomeGerente;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtSenha;

    private RestauranteService restauranteService = new RestauranteService();
    private GerenteService gerenteService = new GerenteService();

    @FXML
    public void salvar(ActionEvent event) {

        if (restauranteService.restauranteExiste()) {

            mostrarAviso("O sistema já foi configurado.");
            return;

        }

        if (Validacao.campoVazio(txtNomeFantasia.getText())
                || Validacao.campoVazio(txtEndereco.getText())
                || Validacao.campoVazio(txtCategoria.getText())
                || Validacao.campoVazio(txtNomeGerente.getText())
                || Validacao.campoVazio(txtSenha.getText())) {

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
                txtEmail.getText());

        Gerente gerente = new Gerente(
                txtNomeGerente.getText(),
                txtEmail.getText(),
                txtSenha.getText());

        restauranteService.configurarRestaurante(restaurante);
        gerenteService.cadastrarGerente(gerente);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Configuração realizada com sucesso!");
        alert.showAndWait();

        TrocarTela.abrir(
                (Stage) txtNomeFantasia.getScene().getWindow(),
                "Login.fxml");

    }

    private void mostrarAviso(String mensagem) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();

    }

}