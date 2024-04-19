package com.wardrobemanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class ItemsController {

    @FXML
    private Button btnItem;

    @FXML
    private ImageView imgItem;

    @FXML
    protected void btnItemClicked() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imgItem.setImage(image);
        }
    }


}
