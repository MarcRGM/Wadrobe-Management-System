package com.wardrobemanagementsystem;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class WardrobeGUI extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Wardrobe Management System");
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/wardrobemanagementsystem/logo.png")));

         // Load the splash screen FXML
        Parent splash = FXMLLoader.load(WardrobeGUI.class.getResource("splash.fxml"));

        Scene splashScene = new Scene(splash);

        stage.setScene(splashScene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.DECORATED);
        stage.show();


        // Load the wardrobe FXML
        PauseTransition delay = new PauseTransition(Duration.seconds(6)); //
        delay.setOnFinished(event -> {
            try {
                Parent wardrobeGUI = FXMLLoader.load(WardrobeGUI.class.getResource("wardrobe.fxml"));

                Scene mainScene = new Scene(wardrobeGUI);
                stage.setScene(mainScene);
                stage.setResizable(false);
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        delay.play();

    }

}

