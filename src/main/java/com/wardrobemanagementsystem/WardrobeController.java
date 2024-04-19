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


    // Used for adding image
    @FXML
    private ImageView imageChange;


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


    // Function for adding image
    @FXML
    protected void btnAddImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imageChange.setImage(image);
        }
    }

    // for grid pane
    // max colum is 4, so if row == 3, move to the next column

}
