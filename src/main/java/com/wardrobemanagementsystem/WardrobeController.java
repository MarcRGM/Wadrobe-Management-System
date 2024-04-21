package com.wardrobemanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;

public class WardrobeController implements Initializable {

    // HashMap is an unordered collection that stores elements in key-value pairs <Key, Value>,
    // allowing us to access them using a key.
    // The keys in a HashMap must be unique, while values can be duplicated.
    // HashMap is useful when we need to store a collection of objects that can be accessed efficiently using a key,
    // instead of an index.
    private HashMap<String, Clothing> clothes = new HashMap<>();
    private HashMap<String, Accessories> accessors = new HashMap<>();
    private HashMap<String, Footwear> footwears = new HashMap<>();

    @FXML
    private Pane footGetInfoPane;

    @FXML
    private Label footNumLabel, topNumLabel, bottomNumLabel;

    @FXML
    private TabPane mainTabPane, clothCategoryTab, accCategoryTab;

    @FXML
    private Tab clothTab, clothTopTab, clothBottomTab,
            accTab, footTab, headTab, neckTab, handTab;

    @FXML
    private ComboBox<String> footCategory;

    @FXML
    private GridPane footGrid;

    @FXML
    private Button btnAddFoot, btnCloseInfo, btnFootInfoConfirm, btnFootSetImage;

    @FXML
    private Label lblFootName;

    @FXML
    private TextField txtFieldFootName, txtFieldFootBrand, txtFieldFootColor;

    Image tempImage;

    @FXML
    ImageView tempImageItem;

    Image blankImage = new Image("C:/Users/marcr/Desktop/WardrobeManagementSystem/src/main/resources/com/whitespace.png");

    // Footwear Columns and Row
    private int footMaxCOl = 3;
    private int footMaxROw = 2;
    private int footCurrentCol = 0;
    private int footCurrentRow = 0;

    // MAX STORAGE
    // CLOTHING: TOP = 8, BOTTOM = 8
    // ACCESSORIES: HEAD = 4, NECK = 10, HAND = 8
    // FOOTWEAR: 6

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadItemBox();

    }

    private void loadItemBox() {
        setBtnAddFoot(footCurrentCol, footCurrentRow);
        setCategories();
        tempImageItem.setImage(blankImage);
    }

    private void setBtnAddFoot(int col, int row) {
        btnAddFoot.setVisible(true);

        btnAddFoot.setMinWidth(Region.USE_COMPUTED_SIZE);
        btnAddFoot.setMinHeight(Region.USE_COMPUTED_SIZE);
        btnAddFoot.setPrefWidth(Region.USE_COMPUTED_SIZE);
        btnAddFoot.setPrefHeight(Region.USE_COMPUTED_SIZE);
        btnAddFoot.setMaxWidth(Region.USE_COMPUTED_SIZE);
        btnAddFoot.setMaxHeight(Region.USE_COMPUTED_SIZE);

        footGrid.add(btnAddFoot, col, row);
        GridPane.setMargin(btnAddFoot, new Insets(10));
        GridPane.setHalignment(btnAddFoot, HPos.CENTER);
        GridPane.setValignment(btnAddFoot, VPos.CENTER);
    }

    private void setCategories() {
        footCategory.getItems().setAll(Arrays.stream(Footwear.Categories.values())
                                          .map(Footwear.Categories::getDisplayName)
                                          .toArray(String[]::new));
    }

    @FXML
    protected void btnAddFootClicked() {
        footGetInfoPane.setVisible(true);
        tempImageItem.setImage(blankImage);
    }

    @FXML
    protected void clothingTopClicked() {
        mainTabPane.getSelectionModel().select(clothTab);
        clothCategoryTab.getSelectionModel().select(clothTopTab);
    }

    @FXML
    protected void clothingBottomClicked() {
        mainTabPane.getSelectionModel().select(clothTab);
        clothCategoryTab.getSelectionModel().select(clothBottomTab);
    }

    @FXML
    protected void headClicked() {
        mainTabPane.getSelectionModel().select(accTab);
        accCategoryTab.getSelectionModel().select(headTab);
    }

    @FXML
    protected void neckClicked() {
        mainTabPane.getSelectionModel().select(accTab);
        accCategoryTab.getSelectionModel().select(neckTab);
    }

    @FXML
    protected void handClicked() {
        mainTabPane.getSelectionModel().select(accTab);
        accCategoryTab.getSelectionModel().select(handTab);
    }


    @FXML
    protected void footClicked() {
        mainTabPane.getSelectionModel().select(footTab);
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
        footwears.get(txtFieldFootName.getText()).setCategory(footCategory.getValue());
        footwears.get(txtFieldFootName.getText()).setImage(tempImage);

        clearGridPaneCell(footGrid, footCurrentRow, footCurrentCol);

        footGrid.add(new ItemButton(new ImageView(tempImage)).getButton(), footCurrentCol++, footCurrentRow);

        if (footCurrentCol == 3 & footCurrentRow == 0) {
            footCurrentRow++;
            footCurrentCol = 0;
        }

        if (!(footCurrentCol == 3 & footCurrentRow == 1)) {
            setBtnAddFoot(footCurrentCol, footCurrentRow);
        }


        footGetInfoPane.setVisible(false);
        tempImage = blankImage;
    }

    private void clearGridPaneCell(GridPane gridPane, int row, int col) {
    gridPane.getChildren().removeIf(node ->
        GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col
    );
}


    @FXML
    protected void btnCloseInfoClicked() {
        tempImageItem.setImage(blankImage);
        footGetInfoPane.setVisible(false);
    }



}
