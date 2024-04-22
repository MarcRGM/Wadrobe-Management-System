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
    private TabPane mainTabPane, clothCategoryTab, accCategoryTab;

    @FXML
    private Tab clothTab, clothTopTab, clothBottomTab,
            accTab, footTab, headTab, neckTab, handTab;

    Image tempImage;

    @FXML
    ImageView tempImageItem, showItemImg;

    // MAX STORAGE
    // CLOTHING: TOP = 8, BOTTOM = 8
    // ACCESSORIES: HEAD = 4, NECK = 10, HAND = 8
    // FOOTWEAR: 6


    // Footwear
    private final int footMaxCol = 3;
    private final int footMaxRow = 2;
    private int footCurrentCol = 0;
    private int footCurrentRow = 0;
    private String[] trackFootItemGrid = new String[footMaxCol * footMaxRow];
    private int trackFootItems = 0;
    private HashMap<String, Button> footItems = new HashMap<>();
    @FXML
    private GridPane footGrid;
    @FXML
    private Button btnAddFoot, btnFootInfoConfirm;
    @FXML
    private ComboBox<String> footCategory;
    private String currFootItem;
    @FXML
    private Label lblFootName, lblFootBrand, lblFootCategory, lblFootColor;
    @FXML
    private TextField txtFieldFootName, txtFieldFootBrand, txtFieldFootColor;
    @FXML
    private Pane footGetInfoPane, footShowInfoPane;


    // Top Clothing
    private final int topMaxCol = 3;
    private final int topMaxRow = 3;
    private int topCurrentCol = 0;
    private int topCurrentRow = 0;
    private String[] trackTopItemGrid = new String[footMaxCol * footMaxRow];
    private int trackTopItems = 0;
    private HashMap<String, Button> topItems = new HashMap<>();
    @FXML
    private GridPane topGrid;
    @FXML
    private Button btnAddTop, btnTopInfoConfirm;
    @FXML
    private ComboBox<String> topCategory;
    private String currTopItem;
    @FXML
    private Label lblTopName, lblTopBrand, lblTopCategory, lblTopColor;
    @FXML
    private TextField txtFieldTopName, txtFieldTopBrand, txtFieldTopColor;
    @FXML
    private Pane topGetInfoPane, topShowInfoPane;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadItemBox();
    }

    private void loadItemBox() {
        setBtnAddFoot(footCurrentCol, footCurrentRow);
        setBtnAddTop(topCurrentCol, topCurrentRow);
        setCategories();
        tempImageItem.setImage(null);
    }

    private void setCategories() {
        footCategory.getItems().setAll(Arrays.stream(Footwear.Categories.values())
                                          .map(Footwear.Categories::getDisplayName)
                                          .toArray(String[]::new));
        topCategory.getItems().setAll(Arrays.stream(Clothing.TopCategories.values())
                                          .map(Clothing.TopCategories::getDisplayName)
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





    // ---------- Top Tab Functions ----------

    private void setBtnAddTop(int col, int row) {
        btnAddTop.setVisible(true);

        btnAddTop.setMinWidth(Region.USE_COMPUTED_SIZE);
        btnAddTop.setMinHeight(Region.USE_COMPUTED_SIZE);
        btnAddTop.setPrefWidth(Region.USE_COMPUTED_SIZE);
        btnAddTop.setPrefHeight(Region.USE_COMPUTED_SIZE);
        btnAddTop.setMaxWidth(Region.USE_COMPUTED_SIZE);
        btnAddTop.setMaxHeight(Region.USE_COMPUTED_SIZE);


        topGrid.getChildren().remove(btnAddTop);
        topGrid.add(btnAddTop, col, row);
        GridPane.setMargin(btnAddTop, new Insets(10));
        GridPane.setHalignment(btnAddTop, HPos.CENTER);
        GridPane.setValignment(btnAddTop, VPos.CENTER);
    }

    @FXML
    protected void btnAddTopClicked() {
        clearControls();
        topGetInfoPane.setVisible(true);
        tempImageItem.setImage(null);
    }

    // ADD ITEMS ON FOOTWEAR GRID
    @FXML
    protected void btnTopInfoConfirmClicked () {
        if (clothes.containsKey(txtFieldTopName.getText())) {
            txtFieldTopName.setText("NAME ALREADY EXISTS!");                           // NOT SHOWING
            btnTopInfoConfirm.disableProperty().setValue(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            txtFieldTopName.clear();
            btnTopInfoConfirm.disableProperty().setValue(false);
        } else if (txtFieldTopName.getText().equals("")) {
            txtFieldTopName.setText("NAME REQUIRED");                                  // NOT SHOWING
            btnTopInfoConfirm.disableProperty().setValue(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            txtFieldTopName.clear();
            btnTopInfoConfirm.disableProperty().setValue(false);
        } else {
            clothes.put(txtFieldTopName.getText(), new Clothing());

            clothes.get(txtFieldTopName.getText()).setName(txtFieldTopName.getText());
            clothes.get(txtFieldTopName.getText()).setBrand(txtFieldTopBrand.getText());
            clothes.get(txtFieldTopName.getText()).setColor(txtFieldTopColor.getText());
            clothes.get(txtFieldTopName.getText()).setCategory(topCategory.getValue());
            clothes.get(txtFieldTopName.getText()).setImage(tempImage);

            ItemButton tempItemButton = new ItemButton(new ImageView(tempImage), txtFieldTopName.getText());
            trackTopItemGrid[trackTopItems++] = tempItemButton.getName();

            topItems.put(tempItemButton.getName(), tempItemButton.getButton());
            topGrid.add(tempItemButton.getButton(), footCurrentCol, footCurrentRow);

            topCurrentCol = trackTopItems % topMaxCol;
            topCurrentRow = trackTopItems / topMaxCol;

            tempItemButton.getButton().setOnAction(event -> {
                topShowInfoPane.setVisible(true);
                showItemImg.setImage(clothes.get(tempItemButton.getName()).getImage());
                lblTopName.setText(clothes.get(tempItemButton.getName()).getName());
                lblTopBrand.setText(clothes.get(tempItemButton.getName()).getBrand());
                lblTopColor.setText(clothes.get(tempItemButton.getName()).getColor());
                lblTopCategory.setText(clothes.get(tempItemButton.getName()).getCategoryName());
                currTopItem = clothes.get(tempItemButton.getName()).getName();
                topGetInfoPane.setVisible(false);
            });

            if (!(topCurrentRow == 3 && topCurrentCol == 0)) {
                setBtnAddTop(topCurrentCol, topCurrentRow);
            }

            topGetInfoPane.setVisible(false);
            tempImage = null;
            clearControls();
        }
    }

    @FXML
    protected void removeTopItem() {
        topShowInfoPane.setVisible(false);

        int index = 0;

        // Find the index of the current foot item
        for (int i = 0; i < trackTopItems; i++) {
            if (trackTopItemGrid[i].equals(currTopItem)) {
                index = i;
                break;
            }
        }

        // Remove the button from the grid
        topGrid.getChildren().remove(topItems.get(currTopItem));


        // Remove the item from tracking arrays and hash map
        trackTopItemGrid[index] = null;
        topItems.remove(currTopItem);
        clothes.remove(currTopItem);


        // Update the grid layout
        // Shift the remaining items in the tracking array
        for (int i = index; i < trackTopItems - 1; i++) {
            trackTopItemGrid[i] = trackTopItemGrid[i + 1];

            topGrid.getChildren().remove(topItems.get(trackTopItemGrid[i+1]));

            int newRow = i / topMaxCol;
            int newCol = i % topMaxCol;

            topGrid.add(topItems.get(trackTopItemGrid[i]), newCol, newRow);

        }

        // Update the number of tracked items
        trackTopItems--;

        topCurrentCol = trackTopItems % topMaxCol;
        topCurrentRow = trackTopItems / topMaxCol;

        // Reset the add button position
        setBtnAddTop(topCurrentCol, topCurrentRow);

        clearControls();
    }

    // ---------- Top Tab Functions END ----------









    // ---------- Footwear Tab Functions ----------

    private void setBtnAddFoot(int col, int row) {
        btnAddFoot.setVisible(true);

        btnAddFoot.setMinWidth(Region.USE_COMPUTED_SIZE);
        btnAddFoot.setMinHeight(Region.USE_COMPUTED_SIZE);
        btnAddFoot.setPrefWidth(Region.USE_COMPUTED_SIZE);
        btnAddFoot.setPrefHeight(Region.USE_COMPUTED_SIZE);
        btnAddFoot.setMaxWidth(Region.USE_COMPUTED_SIZE);
        btnAddFoot.setMaxHeight(Region.USE_COMPUTED_SIZE);


        footGrid.getChildren().remove(btnAddFoot);
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

    // ADD ITEMS ON FOOTWEAR GRID
    @FXML
    protected void btnFootInfoConfirmClicked () {
        if (footwears.containsKey(txtFieldFootName.getText())) {
            txtFieldFootName.setText("NAME ALREADY EXISTS!");                           // NOT SHOWING
            btnFootInfoConfirm.disableProperty().setValue(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            txtFieldFootName.clear();
            btnFootInfoConfirm.disableProperty().setValue(false);
        } else if (txtFieldFootName.getText().equals("")) {
            txtFieldFootName.setText("NAME REQUIRED");                                  // NOT SHOWING
            btnFootInfoConfirm.disableProperty().setValue(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            txtFieldFootName.clear();
            btnFootInfoConfirm.disableProperty().setValue(false);
        } else {
            footwears.put(txtFieldFootName.getText(), new Footwear());

            footwears.get(txtFieldFootName.getText()).setName(txtFieldFootName.getText());
            footwears.get(txtFieldFootName.getText()).setBrand(txtFieldFootBrand.getText());
            footwears.get(txtFieldFootName.getText()).setColor(txtFieldFootColor.getText());
            footwears.get(txtFieldFootName.getText()).setCategory(footCategory.getValue());
            footwears.get(txtFieldFootName.getText()).setImage(tempImage);

            ItemButton tempItemButton = new ItemButton(new ImageView(tempImage), txtFieldFootName.getText());
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
        footwears.remove(currFootItem);


        // Update the grid layout
        // Shift the remaining items in the tracking array
        for (int i = index; i < trackFootItems - 1; i++) {
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

        // Reset the add button position
        setBtnAddFoot(footCurrentCol, footCurrentRow);

        clearControls();
    }

    // ---------- Footwear Tab Functions END ----------

    @FXML
    protected void btnSetImage() {
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
