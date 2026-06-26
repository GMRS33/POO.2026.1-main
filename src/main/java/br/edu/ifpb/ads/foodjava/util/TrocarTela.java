package br.edu.ifpb.ads.foodjava.util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TrocarTela {

    public static void abrir(Stage stage, String fxml) {

        try {

            Parent root = FXMLLoader.load(TrocarTela.class.getResource("/fxml/" + fxml));

            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}