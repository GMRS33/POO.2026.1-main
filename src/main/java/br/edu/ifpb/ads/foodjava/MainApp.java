package br.edu.ifpb.ads.foodjava;

import br.edu.ifpb.ads.foodjava.service.GerenteService;
import br.edu.ifpb.ads.foodjava.service.RestauranteService;
import br.edu.ifpb.ads.foodjava.util.TrocarTela;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        GerenteService gerenteService = new GerenteService();
        RestauranteService restauranteService = new RestauranteService();

        if (!gerenteService.gerenteExiste()
                || !restauranteService.restauranteExiste()) {

            TrocarTela.abrir(stage, "ConfiguracaoInicial.fxml");

        } else {

            TrocarTela.abrir(stage, "Login.fxml");

        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}