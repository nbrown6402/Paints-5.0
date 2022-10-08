package com.example.paints;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Paint extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Paint.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest((WindowEvent w) -> {
            w.consume();
            try {
                new HelloController().bye(w);
            } catch (IOException e) {
                System.out.println("No close");
            }
        });

    }

    public static void main(String[] args) {
        launch();
    }
}