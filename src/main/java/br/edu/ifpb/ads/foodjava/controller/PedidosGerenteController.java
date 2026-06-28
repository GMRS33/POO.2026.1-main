package br.edu.ifpb.ads.foodjava.controller;

import java.time.format.DateTimeFormatter;

import br.edu.ifpb.ads.foodjava.model.Pedido;
import br.edu.ifpb.ads.foodjava.model.StatusPedido;
import br.edu.ifpb.ads.foodjava.service.PedidoService;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class PedidosGerenteController {

	@FXML
	private TableView<Pedido> tablePedidos;

	@FXML
	private TableColumn<Pedido, String> colId;

	@FXML
	private TableColumn<Pedido, String> colCliente;

	@FXML
	private TableColumn<Pedido, String> colData;

	@FXML
	private TableColumn<Pedido, Double> colTotal;

	@FXML
	private TableColumn<Pedido, String> colStatus;

	@FXML
	private ComboBox<StatusPedido> comboStatus;

	private PedidoService pedidoService = new PedidoService();

	@FXML
	public void initialize() {

		colId.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getId()));

		colCliente.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCliente().getNome()));

		colData.setCellValueFactory(cell -> new SimpleStringProperty(
				cell.getValue().getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));

		colTotal.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getValorTotal()));

		colStatus.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getStatus().toString()));

		comboStatus.setItems(FXCollections.observableArrayList(StatusPedido.values()));

		atualizar();

	}

	@FXML
	public void atualizar() {

		tablePedidos.setItems(FXCollections.observableArrayList(pedidoService.listarPedidos()));

	}

	@FXML
	public void alterarStatus() {

		Pedido pedido = tablePedidos.getSelectionModel().getSelectedItem();

		if (pedido == null) {

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setContentText("Selecione um pedido.");
			alert.showAndWait();

			return;

		}

		if (comboStatus.getValue() == null) {

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setContentText("Selecione um status.");
			alert.showAndWait();

			return;

		}

		pedido.setStatus(comboStatus.getValue());

		pedidoService.atualizarPedido(pedido);

		atualizar();

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText("Status atualizado com sucesso!");
		alert.showAndWait();

	}

	@FXML
	public void voltar() {

		TrocarTela.abrir((Stage) tablePedidos.getScene().getWindow(), "TelaGerente.fxml");

	}

}