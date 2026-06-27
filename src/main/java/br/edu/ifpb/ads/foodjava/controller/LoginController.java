package br.edu.ifpb.ads.foodjava.controller;

import br.edu.ifpb.ads.foodjava.exception.SenhaInvalidaException;
import br.edu.ifpb.ads.foodjava.model.Cliente;
import br.edu.ifpb.ads.foodjava.model.Gerente;
import br.edu.ifpb.ads.foodjava.service.ClienteService;
import br.edu.ifpb.ads.foodjava.service.GerenteService;
import br.edu.ifpb.ads.foodjava.util.Sessao;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtSenha;

    private ClienteService clienteService = new ClienteService();
    private GerenteService gerenteService = new GerenteService();

    @FXML
    public void entrar() {

        String email = txtEmail.getText();
        String senha = txtSenha.getText();

        try {

            // Login do gerente
            Gerente gerente = gerenteService.login(email, senha);

            if (gerente != null) {

                Sessao.setGerenteLogado(gerente);
                Sessao.setClienteLogado(null);

                TrocarTela.abrir(
                        (Stage) txtEmail.getScene().getWindow(),
                        "TelaGerente.fxml");

                return;
            }

            // Login do cliente
            Cliente cliente = clienteService.login(email, senha);

            if (cliente != null) {

                Sessao.setClienteLogado(cliente);
                Sessao.setGerenteLogado(null);

                TrocarTela.abrir(
                        (Stage) txtEmail.getScene().getWindow(),
                        "TelaCliente.fxml");

                return;
            }

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Usuário não encontrado.");
            alert.showAndWait();

        } catch (SenhaInvalidaException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }

    }

    @FXML
    public void abrirCadastroCliente() {

        TrocarTela.abrir(
                (Stage) txtEmail.getScene().getWindow(),
                "CadastroCliente.fxml");

    }

    @FXML
    public void abrirCadastroGerente() {

        TrocarTela.abrir(
                (Stage) txtEmail.getScene().getWindow(),
                "CadastroGerente.fxml");

    }

}