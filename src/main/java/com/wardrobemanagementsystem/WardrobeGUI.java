package com.wardrobemanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WardrobeGUI extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WardrobeGUI.class.getResource("wardrobe.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wardrobe Management System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


}
