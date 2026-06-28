package br.edu.ifpb.ads.foodjava.controller;

import br.edu.ifpb.ads.foodjava.exception.UsuarioDuplicadoException;
import br.edu.ifpb.ads.foodjava.model.Cliente;
import br.edu.ifpb.ads.foodjava.service.ClienteService;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
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
	public void cadastrar() {

		try {

			Cliente cliente = new Cliente(txtNome.getText(), txtEmail.getText(), txtSenha.getText(), txtCpf.getText(),
					txtTelefone.getText(), txtEndereco.getText());

			cliente.setNome(txtNome.getText());
			cliente.setEmail(txtEmail.getText());
			cliente.setSenha(txtSenha.getText());

			service.cadastrarCliente(cliente);

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Cliente cadastrado com sucesso!");
			alert.showAndWait();

			voltar();

		} catch (UsuarioDuplicadoException e) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();

		}

	}

	@FXML
	public void voltar() {

		TrocarTela.abrir((Stage) txtNome.getScene().getWindow(), "Login.fxml");

	}

}