package br.edu.ifpb.ads.foodjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
public class MainApp extends Application {

	@Override
	public void start(Stage stage) {

	    TrocarTela.abrir(stage, "ConfiguracaoInicial.fxml");

	    stage.setTitle("FoodJava");

	}
	

    public static void main(String[] args) {
        launch(args);
    }
}
