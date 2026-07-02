package br.edu.ifpb.ads.foodjava.util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TrocarTela {

    public static void abrir(Stage stage, String fxml) {

        try {

            Parent root = FXMLLoader.load(
                    TrocarTela.class.getResource("/fxml/" + fxml));

            Scene scene = new Scene(root);

            scene.getStylesheets().add(
                    TrocarTela.class
                            .getResource("/css/estilo.css")
                            .toExternalForm());

            stage.setScene(scene);

            switch (fxml) {

                case "Login.fxml":
                    stage.setTitle("FoodJava - Login");
                    break;

                case "CadastroCliente.fxml":
                    stage.setTitle("FoodJava - Cadastro de Cliente");
                    break;

                case "ConfiguracaoInicial.fxml":
                    stage.setTitle("FoodJava - Configuração Inicial");
                    break;

                case "TelaCliente.fxml":
                    stage.setTitle("FoodJava - Área do Cliente");
                    break;

                case "TelaGerente.fxml":
                    stage.setTitle("FoodJava - Painel do Gerente");
                    break;

                case "CadastroItemCardapio.fxml":
                    stage.setTitle("FoodJava - Cadastro de Item do Cardápio");
                    break;

                case "EditarItemCardapio.fxml":
                    stage.setTitle("FoodJava - Editar Item do Cardápio");
                    break;

                case "Cardapio.fxml":
                    stage.setTitle("FoodJava - Cardápio");
                    break;

                case "CardapioGerente.fxml":
                    stage.setTitle("FoodJava - Cardápio do Gerente");
                    break;

                case "Carrinho.fxml":
                    stage.setTitle("FoodJava - Carrinho");
                    break;

                case "PedidosCliente.fxml":
                    stage.setTitle("FoodJava - Meus Pedidos");
                    break;

                case "PedidosGerente.fxml":
                    stage.setTitle("FoodJava - Gerenciamento de Pedidos");
                    break;

                case "EditarRestaurante.fxml":
                    stage.setTitle("FoodJava - Editar Restaurante");
                    break;

                default:
                    stage.setTitle("FoodJava");
                    break;

            }

            stage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}