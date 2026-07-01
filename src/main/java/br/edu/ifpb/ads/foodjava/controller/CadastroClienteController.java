package br.edu.ifpb.ads.foodjava.controller;

import br.edu.ifpb.ads.foodjava.exception.UsuarioDuplicadoException;
import br.edu.ifpb.ads.foodjava.model.Cliente;
import br.edu.ifpb.ads.foodjava.service.ClienteService;
import br.edu.ifpb.ads.foodjava.util.MascaraUtil;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import br.edu.ifpb.ads.foodjava.util.Validacao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroClienteController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtSenha;

    private ClienteService service = new ClienteService();

    @FXML
    public void initialize() {

        MascaraUtil.aplicarMascaraCpf(txtCpf);
        MascaraUtil.aplicarMascaraTelefone(txtTelefone);

    }

    @FXML
    public void cadastrar() {

        if (Validacao.campoVazio(txtNome.getText())
                || Validacao.campoVazio(txtCpf.getText())
                || Validacao.campoVazio(txtTelefone.getText())
                || Validacao.campoVazio(txtEndereco.getText())
                || Validacao.campoVazio(txtEmail.getText())
                || Validacao.campoVazio(txtSenha.getText())) {

            mostrarAviso("Todos os campos são obrigatórios.");
            return;
        }

        if (!Validacao.cpfValido(txtCpf.getText())) {

            mostrarAviso("CPF inválido.");
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

        Cliente cliente = new Cliente(
                txtNome.getText().trim(),
                txtEmail.getText().trim(),
                txtSenha.getText(),
                txtCpf.getText().trim(),
                txtTelefone.getText().trim(),
                txtEndereco.getText().trim());

        try {

            service.cadastrarCliente(cliente);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Cliente cadastrado com sucesso!");
            alert.showAndWait();

            TrocarTela.abrir(
                    (Stage) txtNome.getScene().getWindow(),
                    "Login.fxml");

        } catch (UsuarioDuplicadoException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }

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
                "Login.fxml");

    }

}