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

import java.io.InputStream;

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
    private Pane footGetInfoPane, footShowInfoPane;

    @FXML
    private Label lblTop;

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

    private String currFootItem;

    @FXML
    private Label lblFootName, lblFootBrand, lblFootCategory, lblFootColor;

    @FXML
    private TextField txtFieldFootName, txtFieldFootBrand, txtFieldFootColor;

    Image tempImage;

    @FXML
    ImageView tempImageItem, showItemImg;

    // MAX STORAGE
    // CLOTHING: TOP = 8, BOTTOM = 8
    // ACCESSORIES: HEAD = 4, NECK = 10, HAND = 8
    // FOOTWEAR: 6

    // Footwear Columns and Row
    private final int footMaxCol = 3;
    private final int footMaxRow = 2;
    private int footCurrentCol = 0;
    private int footCurrentRow = 0;
    private int footArrCount = 0;
    private String[] trackFootItemGrid = new String[footMaxCol * footMaxRow];
    private int trackFootItems = 0;
    private HashMap<String, Button> footItems = new HashMap<>();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadItemBox();
    }

    private void loadItemBox() {
        setBtnAddFoot(footCurrentCol, footCurrentRow);
        setCategories();
        tempImageItem.setImage(null);
    }

    private void setCategories() {
        footCategory.getItems().setAll(Arrays.stream(Footwear.Categories.values())
                                          .map(Footwear.Categories::getDisplayName)
                                          .toArray(String[]::new));
    }


    // ---------- Wardrobe click ----------

    @FXML
    protected void clothingTopClicked() {
        clearControls();
        mainTabPane.getSelectionModel().select(clothTab);
        clothCategoryTab.getSelectionModel().select(clothTopTab);
    }

    @FXML
    protected void clothingBottomClicked() {
        clearControls();
        mainTabPane.getSelectionModel().select(clothTab);
        clothCategoryTab.getSelectionModel().select(clothBottomTab);
    }

    @FXML
    protected void headClicked() {
        clearControls();
        mainTabPane.getSelectionModel().select(accTab);
        accCategoryTab.getSelectionModel().select(headTab);
    }

    @FXML
    protected void neckClicked() {
        clearControls();
        mainTabPane.getSelectionModel().select(accTab);
        accCategoryTab.getSelectionModel().select(neckTab);
    }

    @FXML
    protected void handClicked() {
        clearControls();
        mainTabPane.getSelectionModel().select(accTab);
        accCategoryTab.getSelectionModel().select(handTab);
    }


    @FXML
    protected void footClicked() {
        clearControls();
        mainTabPane.getSelectionModel().select(footTab);
    }

    @FXML
    protected void clothTabClicked() {
        clearControls();
    }

    @FXML
    protected void accTabClicked() {
        clearControls();
    }

    @FXML
    protected void footTabClicked() {
        clearControls();
    }

    // ---------- Wardrobe click ----------


    // ---------- Footwear Tab Functions ----------

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

    @FXML
    protected void btnAddFootClicked() {
        clearControls();
        footGetInfoPane.setVisible(true);
        tempImageItem.setImage(null);
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

    // ADD ITEMS ON FOOTWEAR GRID
    @FXML
    protected void btnFootInfoConfirmClicked () {
        String name;

        if (txtFieldFootName.getText().equals("")) {
            name = "null";
            footwears.put(name, new Footwear());
        } else {
            name = txtFieldFootName.getText();
            footwears.put(name, new Footwear());
        }

        footwears.get(name).setName(name);
        footwears.get(name).setBrand(txtFieldFootBrand.getText());
        footwears.get(name).setColor(txtFieldFootColor.getText());
        footwears.get(name).setCategory(footCategory.getValue());
        footwears.get(name).setImage(tempImage);

        ItemButton tempItemButton = new ItemButton(new ImageView(tempImage), name);
        trackFootItemGrid[trackFootItems++] = tempItemButton.getName();

        footItems.put(tempItemButton.getName(), tempItemButton.getButton());
        footGrid.add(tempItemButton.getButton(), footCurrentCol, footCurrentRow);

        footCurrentCol = trackFootItems % footMaxCol;
        footCurrentRow = trackFootItems / footMaxCol;

        tempItemButton.getButton().setOnAction(event -> {
            footShowInfoPane.setVisible(true);
            showItemImg.setImage(footwears.get(tempItemButton.getName()).getImage());
            lblFootName.setText(footwears.get(tempItemButton.getName()).getName());
            lblFootBrand.setText(footwears.get(tempItemButton.getName()).getBrand());
            lblFootColor.setText(footwears.get(tempItemButton.getName()).getColor());
            lblFootCategory.setText(footwears.get(tempItemButton.getName()).getCategoryName());
            currFootItem = footwears.get(tempItemButton.getName()).getName();
            footGetInfoPane.setVisible(false);
        });

        if (!(footCurrentRow == 2 && footCurrentCol == 0)) {
            setBtnAddFoot(footCurrentCol, footCurrentRow);
        }

        footGetInfoPane.setVisible(false);
        tempImage = null;
        clearControls();
    }

    @FXML
    protected void removeFootItem() {
        footShowInfoPane.setVisible(false);

        int index = 0;

        // Find the index of the current foot item
        for (int i = 0; i < trackFootItems; i++) {
            if (trackFootItemGrid[i].equals(currFootItem)) {
                index = i;
                break;
            }
        }

        // Remove the button from the grid
        footGrid.getChildren().remove(footItems.get(currFootItem));


        // Remove the item from tracking arrays and hash map
        trackFootItemGrid[index] = null;
        footItems.remove(currFootItem);

        // Update the grid layout
        rearrangeFootItems(index);

        clearControls();
    }

    private void rearrangeFootItems(int removedIndex) {
        // Shift the remaining items in the tracking array
        for (int i = removedIndex; i < trackFootItems - 1; i++) {
            trackFootItemGrid[i] = trackFootItemGrid[i + 1];

            footGrid.getChildren().remove(footItems.get(trackFootItemGrid[i+1]));

            int newRow = i / footMaxCol;
            int newCol = i % footMaxCol;

            footGrid.add(footItems.get(trackFootItemGrid[i]), newCol, newRow);
            
        }

        // Update the number of tracked items
        trackFootItems--;

        footCurrentCol = trackFootItems % footMaxCol;
        footCurrentRow = trackFootItems / footMaxCol;

        lblTop.setText(footCurrentRow + " " + footCurrentCol);

        // Reset the add button position
        setBtnAddFoot(footCurrentCol, footCurrentRow);
    }


    // ---------- Footwear Tab Functions END ----------

    @FXML
    protected void clearControls() {
        if (tempImage != null) {
            tempImageItem.setImage(null);
        }
        if (txtFieldFootName != null) {
            txtFieldFootName.setText("");
        }
        if (txtFieldFootBrand != null) {
            txtFieldFootBrand.setText("");
        }
        if (txtFieldFootColor != null) {
            txtFieldFootColor.setText("");
        }
        if (footCategory != null) {
            footCategory.setValue("");
        }
        if (footShowInfoPane != null) {
            footShowInfoPane.setVisible(false);
        }
        if (footGetInfoPane != null) {
            footGetInfoPane.setVisible(false);
        }
    }


    private void clearGridPaneCell(GridPane gridPane, int row, int col) {
        gridPane.getChildren().removeIf(node ->
            GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col);
    }



}
