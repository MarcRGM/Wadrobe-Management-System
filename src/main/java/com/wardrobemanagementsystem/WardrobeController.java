package com.wardrobemanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;

public class WardrobeController {

    @FXML
    private Pane paneShirtInfo, paneDressInfo;



    // Experiment
    @FXML
    private ImageView imageChange;

    @FXML
    private Button btnImage;



    @FXML
    protected void btnShirt() {
        paneShirtInfo.setVisible(true);
        paneDressInfo.setVisible(false);
    }

    @FXML
    protected void btnDress() {
        paneDressInfo.setVisible(true);
        paneShirtInfo.setVisible(false);
    }

    @FXML
    protected void btnCloseInfo() {
        paneShirtInfo.setVisible(false);
        paneDressInfo.setVisible(false);
    }


    // Experiment
    @FXML
    protected void btnAddImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(btnImage.getScene().getWindow());

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imageChange.setImage(image);
        }
    }

}
