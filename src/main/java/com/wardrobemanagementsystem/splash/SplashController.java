package com.wardrobemanagementsystem.splash;


import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class SplashController implements Initializable {

    @FXML
    Pane leftCover, rightCover;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TranslateTransition leftCoverSlide = new TranslateTransition(Duration.seconds(3), leftCover);
        leftCoverSlide.setToX(-200);

        TranslateTransition rightCoverSlide = new TranslateTransition(Duration.seconds(3), rightCover);
        rightCoverSlide.setToX(200);

        PauseTransition delay = new PauseTransition(Duration.seconds(2));

        delay.setOnFinished(event -> {
            leftCoverSlide.play();
            rightCoverSlide.play();
        });

        delay.play();

    }
}
