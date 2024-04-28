package com.wardrobemanagementsystem;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class WardrobeGUI extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Wardrobe Management System");
        stage.setResizable(false);

         // Load the splash screen FXML
        Parent splash = FXMLLoader.load(WardrobeGUI.class.getResource("splash.fxml"));

        Scene splashScene = new Scene(splash);

        stage.setScene(splashScene);

        stage.show();

        // Load and display the wardrobe FXML
        PauseTransition delay = new PauseTransition(Duration.seconds(3)); // 3 seconds delay
        delay.setOnFinished(event -> {
            try {
                // Load the main FXML
                Parent wardrobeGUI = FXMLLoader.load(WardrobeGUI.class.getResource("wardrobe.fxml"));

                // Create the scene
                Scene mainScene = new Scene(wardrobeGUI);

                // Set the scene to the stage
                stage.setScene(mainScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        delay.play();


    }

}


