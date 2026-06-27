package br.edu.ifpb.ads.foodjava.controller;

import br.edu.ifpb.ads.foodjava.model.Gerente;
import br.edu.ifpb.ads.foodjava.service.GerenteService;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroGerenteController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtSenha;

    private GerenteService service = new GerenteService();

    @FXML
    public void cadastrar() {

        if (service.gerenteExiste()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Já existe um gerente cadastrado.");
            alert.showAndWait();
            return;

        }

        Gerente gerente = new Gerente(
                txtNome.getText(),
                txtEmail.getText(),
                txtSenha.getText());

        service.cadastrarGerente(gerente);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Gerente cadastrado com sucesso!");
        alert.showAndWait();

        TrocarTela.abrir(
                (Stage) txtNome.getScene().getWindow(),
                "CadastroRestaurante.fxml");

    }

    @FXML
    public void voltar() {

        TrocarTela.abrir(
                (Stage) txtNome.getScene().getWindow(),
                "Login.fxml");

    }

}