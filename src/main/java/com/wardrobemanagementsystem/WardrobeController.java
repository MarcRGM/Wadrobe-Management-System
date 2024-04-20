package com.wardrobemanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WardrobeController implements Initializable {

    @FXML
    private Pane paneShirtInfo, paneDressInfo;

    @FXML
    private GridPane itemGrid;

    // Used for adding image
    @FXML
    private ImageView imageChange;


    int currentCol = 0;
    int currentRow = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadItemBox();
    }

    private void loadItemBox() {
        FXMLLoader fxmlAdd = new FXMLLoader();
        fxmlAdd.setLocation(getClass().getResource("Add.fxml"));

        VBox addBox;
        try {
            addBox = fxmlAdd.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        itemGrid.add(addBox, currentCol, currentRow);
        GridPane.setMargin(addBox, new Insets(20, 20, 20, 20));
        GridPane.setHalignment(addBox, HPos.CENTER);
        GridPane.setValignment(addBox, VPos.CENTER);

    }


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
    protected void addImage() {

    }


}
