package com.wardrobemanagementsystem;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class WardrobeGUI extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Wardrobe Management System");
        stage.setResizable(false);

         // Load the splash screen FXML
        Parent splash = FXMLLoader.load(WardrobeGUI.class.getResource("wardrobe.fxml"));

        Scene splashScene = new Scene(splash);

        stage.setScene(splashScene);

        stage.show();

        /*
        // Load and display the wardrobe FXML
        PauseTransition delay = new PauseTransition(Duration.seconds(3)); // 3 seconds delay
        delay.setOnFinished(event -> {
            try {
                Parent wardrobeGUI = FXMLLoader.load(WardrobeGUI.class.getResource("wardrobe.fxml"));

                Scene mainScene = new Scene(wardrobeGUI);

                stage.setScene(mainScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        delay.play();


         */



    }

}


