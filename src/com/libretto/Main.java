package com.libretto;

import com.libretto.models.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Carica il node radice dal FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Libretto.fxml"));
        Parent root = loader.load();

        // carica il loader con il quale si possono accedere i metodi del controller
        LibrettoController controller = loader.getController();

        Model model = new Model();
        controller.setModel(model);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
