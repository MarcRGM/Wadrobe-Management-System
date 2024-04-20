package com.wardrobemanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;

public class WardrobeController {

    // HashMap is an unordered collection that stores elements in key-value pairs <Key, Value>,
    // allowing us to access them using a key.
    // The keys in a HashMap must be unique, while values can be duplicated.
    // HashMap is useful when we need to store a collection of objects that can be accessed efficiently using a key,
    // instead of an index.
    private HashMap<String, Clothing> clothes = new HashMap<>();
    private HashMap<String, Accessories> accessors = new HashMap<>();
    private HashMap<String, Footwear> footwears = new HashMap<>();

    @FXML
    private Pane paneShirtInfo, paneDressInfo, footInfoPane, footGetInfoPane;

    @FXML
    private GridPane itemGrid;

    @FXML
    private Button btnAddFoot, btnCloseInfo, btnFootInfoConfirm, btnFootSetImage;

    @FXML
    private Label lblFootName;

    @FXML
    private TextField txtFieldFootName, txtFieldFootBrand, txtFieldFootColor, txtFieldFootCategory;

    Image tempImage;

    @FXML
    ImageView tempImageItem;

    int currentCol = 0;
    int currentRow = 0;

    private void loadItemBox() {
        FXMLLoader fxmlAdd = new FXMLLoader();
        fxmlAdd.setLocation(getClass().getResource("items.fxml"));

        VBox addBox;
        try {
            addBox = fxmlAdd.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Clear existing children from the GridPane
        itemGrid.getChildren().clear();


        itemGrid.add(addBox, currentCol++, currentRow++);
        GridPane.setMargin(addBox, new Insets(20, 20, 20, 20));
        GridPane.setHalignment(addBox, HPos.CENTER);
        GridPane.setValignment(addBox, VPos.CENTER);

        itemGrid.add(btnAddFoot, currentCol, currentRow);

    }

    @FXML
    protected void btnAddFoot() {

    }

    @FXML
    protected void btnFootSetImageClicked() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            tempImage = new Image(selectedFile.toURI().toString());
            tempImageItem.setImage(tempImage);
        }
    }

    @FXML
    protected void btnFootInfoConfirmClicked () {
        footwears.put(txtFieldFootName.getText(), new Footwear());
        footwears.get(txtFieldFootName.getText()).setBrand(txtFieldFootBrand.getText());
        footwears.get(txtFieldFootName.getText()).setColor(txtFieldFootColor.getText());
        footwears.get(txtFieldFootName.getText()).setCategory(txtFieldFootCategory.getText());
        footwears.get(txtFieldFootName.getText()).setImage(tempImage);

        loadItemBox();
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
    protected void btnCloseInfoClicked() {
        footInfoPane.setVisible(false);
        footGetInfoPane.setVisible(false);
    }

    @FXML
    protected void btnAddFootClicked() {
        footGetInfoPane.setVisible(true);
    }



}
