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

    private int currentCol = 0;
    private int currentRow = 0;


    // MAX STORAGE
    // CLOTHING: TOP = 8, BOTTOM = 8
    // ACCESSORIES: HEAD = 4, NECK = 10, HAND = 8
    // FOOTWEAR: 6

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadItemBox();

    }

    private void loadItemBox() {
        setBtnAddFoot(currentCol, currentRow);
        setCategories();
        

    }

    private void setBtnAddFoot(int col, int row) {
        itemGrid.add(btnAddFoot, currentCol, currentRow);
        GridPane.setMargin(btnAddFoot, new Insets(Region.USE_COMPUTED_SIZE));
        GridPane.setHalignment(btnAddFoot, HPos.CENTER);
        GridPane.setValignment(btnAddFoot, VPos.CENTER);
    }

    private void setCategories() {
        footCategory.getItems().setAll(Arrays.toString(Footwear.Categories.values()));
    }

    @FXML
    protected void btnAddFootClicked() {
        footGetInfoPane.setVisible(true);
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
        footwears.get(txtFieldFootName.getText()).setCategory(txtFieldFootCategory.getText());
        footwears.get(txtFieldFootName.getText()).setImage(tempImage);

        loadItemBox();
    }

    @FXML
    protected void btnCloseInfoClicked() {
        footGetInfoPane.setVisible(false);
    }



}
