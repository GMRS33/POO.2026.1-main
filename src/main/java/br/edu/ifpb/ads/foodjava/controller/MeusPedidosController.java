package br.edu.ifpb.ads.foodjava.controller;

import java.time.format.DateTimeFormatter;

import br.edu.ifpb.ads.foodjava.model.Pedido;
import br.edu.ifpb.ads.foodjava.service.PedidoService;
import br.edu.ifpb.ads.foodjava.util.Sessao;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class MeusPedidosController {

	@FXML
	private TableView<Pedido> tablePedidos;

	@FXML
	private TableColumn<Pedido, String> colId;

	@FXML
	private TableColumn<Pedido, String> colData;

	@FXML
	private TableColumn<Pedido, Double> colTotal;

	@FXML
	private TableColumn<Pedido, String> colStatus;

	private PedidoService pedidoService = new PedidoService();

	@FXML
	public void initialize() {

		colId.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getId()));

		colData.setCellValueFactory(cell -> new SimpleStringProperty(
				cell.getValue().getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));

		colTotal.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getValorTotal()));

		colStatus.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getStatus().toString()));

		atualizar();

	}

	@FXML
	public void atualizar() {

		tablePedidos.setItems(

				FXCollections.observableArrayList(

						pedidoService.listarPedidosCliente(

								Sessao.getClienteLogado())

				)

		);

	}

	@FXML
	public void voltar() {

		TrocarTela.abrir(

				(Stage) tablePedidos.getScene().getWindow(),

				"TelaCliente.fxml"

		);

	}

}