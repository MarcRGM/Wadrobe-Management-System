package com.wardrobemanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;



public class WardrobeController implements Initializable {

    // HashMap is an unordered collection that stores elements in key-value pairs <Key, Value>,
    // allowing us to access them using a key.
    // The keys in a HashMap must be unique, while values can be duplicated.
    // HashMap is useful when we need to store a collection of objects that can be accessed efficiently using a key,
    // instead of an index.
    private HashMap<String, Clothing> clothes = new HashMap<>();
    private HashMap<String, Accessories> accessories = new HashMap<>();
    private HashMap<String, Footwear> footwears = new HashMap<>();

    @FXML
    private TabPane mainTabPane, clothCategoryTab, accCategoryTab;

    @FXML
    private Tab clothTab, clothTopTab, clothBottomTab,
            accTab, footTab, headTab, neckTab, handTab;

    Image tempImage;

    @FXML
    private Label titleLabel;

    @FXML
    private Rectangle shadow;


    // MAX STORAGE
    // CLOTHING: TOP = 9, BOTTOM = 9
    // ACCESSORIES: HEAD = 6, NECK = 12, HAND = 9
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
    @FXML
    ImageView tempFootImage, showFootImg;


    // clothing
    private final int clothMaxCol = 3;
    private final int clothMaxRow = 3;
    private int topCurrentCol = 0;
    private int topCurrentRow = 0;
    private int botCurrentCol = 0;
    private int botCurrentRow = 0;
    private String[] trackTopItemGrid = new String[clothMaxCol * clothMaxRow];
    private String[] trackBotItemGrid = new String[clothMaxCol * clothMaxRow];
    private int trackTopItems = 0;
    private int trackBotItems = 0;
    private HashMap<String, Button> topItems = new HashMap<>();
    private HashMap<String, Button> botItems = new HashMap<>();
    @FXML
    private GridPane topGrid, botGrid;
    @FXML
    private Button btnAddTop, btnTopInfoConfirm, btnAddBot, btnBotInfoConfirm;
    @FXML
    private ComboBox<String> topCategory, botCategory;
    private String currTopItem, currBotItem;
    @FXML
    private Label lblTopName, lblTopBrand, lblTopCategory, lblTopColor,
    lblBotName, lblBotBrand, lblBotCategory, lblBotColor;
    @FXML
    private TextField txtFieldTopName, txtFieldTopBrand, txtFieldTopColor,
    txtFieldBotName, txtFieldBotBrand, txtFieldBotColor;
    @FXML
    private Pane topGetInfoPane, topShowInfoPane, botGetInfoPane, botShowInfoPane;
    @FXML
    ImageView tempTopImage, showTopImg, tempBotImage, showBotImg;


    // Head
    private final int headMaxCol = 3;
    private final int headMaxRow = 2;
    private int headCurrentCol = 0;
    private int headCurrentRow = 0;
    private String[] trackHeadItemGrid = new String[headMaxCol * headMaxRow];
    private int trackHeadItems = 0;
    private HashMap<String, Button> headItems = new HashMap<>();
    @FXML
    private GridPane headGrid;
    @FXML
    private Button btnAddHead, btnHeadInfoConfirm;
    @FXML
    private ComboBox<String> headCategory;
    private String currHeadItem;
    @FXML
    private Label lblHeadName, lblHeadBrand, lblHeadCategory, lblHeadColor;
    @FXML
    private TextField txtFieldHeadName, txtFieldHeadBrand, txtFieldHeadColor;
    @FXML
    private Pane headGetInfoPane, headShowInfoPane;
    @FXML
    ImageView tempHeadImage, showHeadImg;


    // Neck
    private final int neckMaxCol = 3;
    private final int neckMaxRow = 4;
    private int neckCurrentCol = 0;
    private int neckCurrentRow = 0;
    private String[] trackNeckItemGrid = new String[neckMaxCol * neckMaxRow];
    private int trackNeckItems = 0;
    private HashMap<String, Button> neckItems = new HashMap<>();
    @FXML
    private GridPane neckGrid;
    @FXML
    private Button btnAddNeck, btnNeckInfoConfirm;
    @FXML
    private ComboBox<String> neckCategory;
    private String currNeckItem;
    @FXML
    private Label lblNeckName, lblNeckBrand, lblNeckCategory, lblNeckColor;
    @FXML
    private TextField txtFieldNeckName, txtFieldNeckBrand, txtFieldNeckColor;
    @FXML
    private Pane neckGetInfoPane, neckShowInfoPane;
    @FXML
    ImageView tempNeckImage, showNeckImg;



    // Hand
    private final int handMaxCol = 3;
    private final int handMaxRow = 3;
    private int handCurrentCol = 0;
    private int handCurrentRow = 0;
    private String[] trackHandItemGrid = new String[handMaxCol * handMaxRow];
    private int trackHandItems = 0;
    private HashMap<String, Button> handItems = new HashMap<>();
    @FXML
    private GridPane handGrid;
    @FXML
    private Button btnAddHand, btnHandInfoConfirm;
    @FXML
    private ComboBox<String> handCategory;
    private String currHandItem;
    @FXML
    private Label lblHandName, lblHandBrand, lblHandCategory, lblHandColor;
    @FXML
    private TextField txtFieldHandName, txtFieldHandBrand, txtFieldHandColor;
    @FXML
    private Pane handGetInfoPane, handShowInfoPane;
    @FXML
    ImageView tempHandImage, showHandImg;


    // OUTFIT CREATION
    @FXML
    private Pane selectGenderPane, outfitCreationPane, outfitsPane, pickItemPane;

    @FXML
    private Button btnShowOutfit, btnCreateOutfit;

    @FXML
    private GridPane pickItemsGrid;

    Image maleFigure = new Image(new File("src/main/java/com/icons8-body-600.png").toURI().toString());
    Image femaleFigure = new Image(new File("src/main/java/com/icons8-girl-body-600.png").toURI().toString());

    String currItemPick, currGenderOutfitCreation;

    @FXML
    private ImageView imgViewMale, imgViewFemale;

    @FXML
    private ImageView imgFigure;

    @FXML
    private ScrollPane itemsScroll, pickItemScroll;

    @FXML
    private Label labelPickItem;






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadItemBox();
    }

    private void loadItemBox() {
        setBtnAddFoot(footCurrentCol, footCurrentRow);
        setBtnAddTop(topCurrentCol, topCurrentRow);
        setBtnAddBot(botCurrentCol, botCurrentRow);
        setBtnAddHead(headCurrentCol, headCurrentRow);
        setBtnAddNeck(neckCurrentCol, neckCurrentRow);
        setBtnAddHand(handCurrentCol, handCurrentRow);
        imgViewMale.setImage(maleFigure);
        imgViewFemale.setImage(femaleFigure);
        setCategories();
        clearControls();
    }

    private void setCategories() {
        footCategory.getItems().setAll(Arrays.stream(Footwear.Categories.values())
                                  .map(Footwear.Categories::getDisplayName)
                                  .toArray(String[]::new));
        topCategory.getItems().setAll(Arrays.stream(Clothing.TopCategories.values())
                                  .map(Clothing.TopCategories::getDisplayName)
                                  .toArray(String[]::new));
        botCategory.getItems().setAll(Arrays.stream(Clothing.BottomCategories.values())
                                  .map(Clothing.BottomCategories::getDisplayName)
                                  .toArray(String[]::new));
        headCategory.getItems().setAll(Arrays.stream(Accessories.HeadMaterialsCategory.values())
                                  .map(Accessories.HeadMaterialsCategory::getDisplayName)
                                  .toArray(String[]::new));
        neckCategory.getItems().setAll(Arrays.stream(Accessories.NeckMaterialsCategory.values())
                                  .map(Accessories.NeckMaterialsCategory::getDisplayName)
                                  .toArray(String[]::new));
        handCategory.getItems().setAll(Arrays.stream(Accessories.HandMaterialsCategory.values())
                                  .map(Accessories.HandMaterialsCategory::getDisplayName)
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

    @FXML
    protected void topTabClicked() {
        clearControls();
    }

    @FXML
    protected void botTabClicked() {
        clearControls();
    }

    @FXML
    protected void headTabClicked() {
        clearControls();
    }

    @FXML
    protected void neckTabClicked() {
        clearControls();
    }

    @FXML
    protected void handTabClicked() {
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
        setGridMargins(btnAddTop);
    }

    @FXML
    protected void btnAddTopClicked() {
        clearControls();
        topGetInfoPane.setVisible(true);
        tempTopImage.setImage(null);
    }

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
            topGrid.add(tempItemButton.getButton(), topCurrentCol, topCurrentRow);
            setGridMargins(tempItemButton.getButton());

            topCurrentCol = trackTopItems % clothMaxCol;
            topCurrentRow = trackTopItems / clothMaxCol;

            tempItemButton.getButton().setOnAction(event -> {
                topShowInfoPane.setVisible(true);
                showTopImg.setImage(clothes.get(tempItemButton.getName()).getImage());
                lblTopName.setText(clothes.get(tempItemButton.getName()).getName());
                lblTopBrand.setText(clothes.get(tempItemButton.getName()).getBrand());
                lblTopColor.setText(clothes.get(tempItemButton.getName()).getColor());
                lblTopCategory.setText(clothes.get(tempItemButton.getName()).getCategory());
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

            int newRow = i / clothMaxCol;
            int newCol = i % clothMaxCol;

            topGrid.add(topItems.get(trackTopItemGrid[i]), newCol, newRow);

        }

        // Update the number of tracked items
        trackTopItems--;

        topCurrentCol = trackTopItems % clothMaxCol;
        topCurrentRow = trackTopItems / clothMaxCol;

        // Reset the add button position
        setBtnAddTop(topCurrentCol, topCurrentRow);

        clearControls();
    }

    // ---------- Top Tab Functions END ----------





    // ---------- Bottom Tab Functions ----------

    private void setBtnAddBot(int col, int row) {
        btnAddBot.setVisible(true);

        btnAddBot.setMinWidth(Region.USE_COMPUTED_SIZE);
        btnAddBot.setMinHeight(Region.USE_COMPUTED_SIZE);
        btnAddBot.setPrefWidth(Region.USE_COMPUTED_SIZE);
        btnAddBot.setPrefHeight(Region.USE_COMPUTED_SIZE);
        btnAddBot.setMaxWidth(Region.USE_COMPUTED_SIZE);
        btnAddBot.setMaxHeight(Region.USE_COMPUTED_SIZE);


        botGrid.getChildren().remove(btnAddBot);
        botGrid.add(btnAddBot, col, row);
        setGridMargins(btnAddBot);
    }

    @FXML
    protected void btnAddBotClicked() {
        clearControls();
        botGetInfoPane.setVisible(true);
        tempBotImage.setImage(null);
    }

    @FXML
    protected void btnBotInfoConfirmClicked () {
        if (clothes.containsKey(txtFieldBotName.getText())) {
            txtFieldBotName.setText("NAME ALREADY EXISTS!");                           // NOT SHOWING
            btnBotInfoConfirm.disableProperty().setValue(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            txtFieldBotName.clear();
            btnBotInfoConfirm.disableProperty().setValue(false);
        } else if (txtFieldBotName.getText().equals("")) {
            txtFieldBotName.setText("NAME REQUIRED");                                  // NOT SHOWING
            btnBotInfoConfirm.disableProperty().setValue(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            txtFieldBotName.clear();
            btnBotInfoConfirm.disableProperty().setValue(false);
        } else {
            clothes.put(txtFieldBotName.getText(), new Clothing());

            clothes.get(txtFieldBotName.getText()).setName(txtFieldBotName.getText());
            clothes.get(txtFieldBotName.getText()).setBrand(txtFieldBotBrand.getText());
            clothes.get(txtFieldBotName.getText()).setColor(txtFieldBotColor.getText());
            clothes.get(txtFieldBotName.getText()).setCategory(botCategory.getValue());
            clothes.get(txtFieldBotName.getText()).setImage(tempImage);

            ItemButton tempItemButton = new ItemButton(new ImageView(tempImage), txtFieldBotName.getText());
            trackBotItemGrid[trackBotItems++] = tempItemButton.getName();

            botItems.put(tempItemButton.getName(), tempItemButton.getButton());
            botGrid.add(tempItemButton.getButton(), botCurrentCol, botCurrentRow);
            setGridMargins(tempItemButton.getButton());

            botCurrentCol = trackBotItems % clothMaxCol;
            botCurrentRow = trackBotItems / clothMaxCol;

            tempItemButton.getButton().setOnAction(event -> {
                botShowInfoPane.setVisible(true);
                showBotImg.setImage(clothes.get(tempItemButton.getName()).getImage());
                lblBotName.setText(clothes.get(tempItemButton.getName()).getName());
                lblBotBrand.setText(clothes.get(tempItemButton.getName()).getBrand());
                lblBotColor.setText(clothes.get(tempItemButton.getName()).getColor());
                lblBotCategory.setText(clothes.get(tempItemButton.getName()).getCategory());
                currBotItem = clothes.get(tempItemButton.getName()).getName();
                botGetInfoPane.setVisible(false);
            });

            if (!(botCurrentRow == 3 && botCurrentCol == 0)) {
                setBtnAddBot(botCurrentCol, botCurrentRow);
            }

            botGetInfoPane.setVisible(false);
            tempImage = null;
            clearControls();
        }
    }

    @FXML
    protected void removeBotItem() {
        botShowInfoPane.setVisible(false);

        int index = 0;

        for (int i = 0; i < trackBotItems; i++) {
            if (trackBotItemGrid[i].equals(currBotItem)) {
                index = i;
                break;
            }
        }

        // Remove the button from the grid
        botGrid.getChildren().remove(botItems.get(currBotItem));


        // Remove the item from tracking arrays and hash map
        trackBotItemGrid[index] = null;
        botItems.remove(currBotItem);
        clothes.remove(currBotItem);


        // Update the grid layout
        // Shift the remaining items in the tracking array
        for (int i = index; i < trackBotItems - 1; i++) {
            trackBotItemGrid[i] = trackBotItemGrid[i + 1];

            botGrid.getChildren().remove(botItems.get(trackBotItemGrid[i+1]));

            int newRow = i / clothMaxCol;
            int newCol = i % clothMaxCol;

            botGrid.add(botItems.get(trackBotItemGrid[i]), newCol, newRow);

        }

        // Update the number of tracked items
        trackBotItems--;

        botCurrentCol = trackBotItems % clothMaxCol;
        botCurrentRow = trackBotItems / clothMaxCol;

        // Reset the add button position
        setBtnAddBot(botCurrentCol, botCurrentRow);

        clearControls();
    }

    // ---------- Bottom Tab Functions END ----------






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
        setGridMargins(btnAddFoot);
    }

    @FXML
    protected void btnAddFootClicked() {
        clearControls();
        footGetInfoPane.setVisible(true);
        tempFootImage.setImage(null);
    }

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
                showFootImg.setImage(footwears.get(tempItemButton.getName()).getImage());
                lblFootName.setText(footwears.get(tempItemButton.getName()).getName());
                lblFootBrand.setText(footwears.get(tempItemButton.getName()).getBrand());
                lblFootColor.setText(footwears.get(tempItemButton.getName()).getColor());
                lblFootCategory.setText(footwears.get(tempItemButton.getName()).getCategory());
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






    // ---------- Headwear Tab Functions ----------

    private void setBtnAddHead(int col, int row) {
        btnAddHead.setVisible(true);

        btnAddHead.setMinWidth(Region.USE_COMPUTED_SIZE);
        btnAddHead.setMinHeight(Region.USE_COMPUTED_SIZE);
        btnAddHead.setPrefWidth(Region.USE_COMPUTED_SIZE);
        btnAddHead.setPrefHeight(Region.USE_COMPUTED_SIZE);
        btnAddHead.setMaxWidth(Region.USE_COMPUTED_SIZE);
        btnAddHead.setMaxHeight(Region.USE_COMPUTED_SIZE);


        headGrid.getChildren().remove(btnAddHead);
        headGrid.add(btnAddHead, col, row);
        setGridMargins(btnAddHead);
    }

    @FXML
    protected void btnAddHeadClicked() {
        clearControls();
        headGetInfoPane.setVisible(true);
        tempHeadImage.setImage(null);
    }

    @FXML
    protected void btnHeadInfoConfirmClicked () {
        if (accessories.containsKey(txtFieldHeadName.getText())) {
            txtFieldHeadName.setText("NAME ALREADY EXISTS!");                           // NOT SHOWING
            btnHeadInfoConfirm.disableProperty().setValue(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            txtFieldHeadName.clear();
            btnHeadInfoConfirm.disableProperty().setValue(false);
        } else if (txtFieldHeadName.getText().equals("")) {
            txtFieldHeadName.setText("NAME REQUIRED");                                  // NOT SHOWING
            btnHeadInfoConfirm.disableProperty().setValue(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            txtFieldHeadName.clear();
            btnHeadInfoConfirm.disableProperty().setValue(false);
        } else {
            accessories.put(txtFieldHeadName.getText(), new Accessories());

            accessories.get(txtFieldHeadName.getText()).setName(txtFieldHeadName.getText());
            accessories.get(txtFieldHeadName.getText()).setBrand(txtFieldHeadBrand.getText());
            accessories.get(txtFieldHeadName.getText()).setColor(txtFieldHeadColor.getText());
            accessories.get(txtFieldHeadName.getText()).setCategory(headCategory.getValue());
            accessories.get(txtFieldHeadName.getText()).setImage(tempImage);

            ItemButton tempItemButton = new ItemButton(new ImageView(tempImage), txtFieldHeadName.getText());
            trackHeadItemGrid[trackHeadItems++] = tempItemButton.getName();

            headItems.put(tempItemButton.getName(), tempItemButton.getButton());
            headGrid.add(tempItemButton.getButton(), headCurrentCol, headCurrentRow);

            headCurrentCol = trackHeadItems % headMaxCol;
            headCurrentRow = trackHeadItems / headMaxCol;

            tempItemButton.getButton().setOnAction(event -> {
                headShowInfoPane.setVisible(true);
                showHeadImg.setImage(accessories.get(tempItemButton.getName()).getImage());
                lblHeadName.setText(accessories.get(tempItemButton.getName()).getName());
                lblHeadBrand.setText(accessories.get(tempItemButton.getName()).getBrand());
                lblHeadColor.setText(accessories.get(tempItemButton.getName()).getColor());
                lblHeadCategory.setText(accessories.get(tempItemButton.getName()).getCategory());
                currHeadItem = accessories.get(tempItemButton.getName()).getName();
                headGetInfoPane.setVisible(false);
            });

            if (!(headCurrentRow == 2 && headCurrentCol == 0)) {
                setBtnAddHead(headCurrentCol, headCurrentRow);
            }

            headGetInfoPane.setVisible(false);
            tempImage = null;
            clearControls();
        }
    }

    @FXML
    protected void removeHeadItem() {
        headShowInfoPane.setVisible(false);

        int index = 0;

        for (int i = 0; i < trackHeadItems; i++) {
            if (trackHeadItemGrid[i].equals(currHeadItem)) {
                index = i;
                break;
            }
        }

        // Remove the button from the grid
        headGrid.getChildren().remove(headItems.get(currHeadItem));


        // Remove the item from tracking arrays and hash map
        trackHeadItemGrid[index] = null;
        headItems.remove(currHeadItem);
        accessories.remove(currHeadItem);


        // Update the grid layout
        // Shift the remaining items in the tracking array
        for (int i = index; i < trackHeadItems - 1; i++) {
            trackHeadItemGrid[i] = trackHeadItemGrid[i + 1];

            headGrid.getChildren().remove(headItems.get(trackHeadItemGrid[i+1]));

            int newRow = i / headMaxCol;
            int newCol = i % headMaxCol;

            headGrid.add(headItems.get(trackHeadItemGrid[i]), newCol, newRow);

        }

        // Update the number of tracked items
        trackHeadItems--;

        headCurrentCol = trackHeadItems % headMaxCol;
        headCurrentRow = trackHeadItems / headMaxCol;

        // Reset the add button position
        setBtnAddHead(headCurrentCol, headCurrentRow);

        clearControls();
    }

    // ---------- Headwear Tab Functions END ----------




    // ---------- Neckwear Tab Functions ----------

    private void setBtnAddNeck(int col, int row) {
        btnAddNeck.setVisible(true);

        btnAddNeck.setMinWidth(Region.USE_COMPUTED_SIZE);
        btnAddNeck.setMinHeight(Region.USE_COMPUTED_SIZE);
        btnAddNeck.setPrefWidth(Region.USE_COMPUTED_SIZE);
        btnAddNeck.setPrefHeight(Region.USE_COMPUTED_SIZE);
        btnAddNeck.setMaxWidth(Region.USE_COMPUTED_SIZE);
        btnAddNeck.setMaxHeight(Region.USE_COMPUTED_SIZE);


        neckGrid.getChildren().remove(btnAddNeck);
        neckGrid.add(btnAddNeck, col, row);
        setGridMargins(btnAddNeck);
    }

    @FXML
    protected void btnAddNeckClicked() {
        clearControls();
        neckGetInfoPane.setVisible(true);
        tempNeckImage.setImage(null);
    }

    @FXML
    protected void btnNeckInfoConfirmClicked () {
        if (clothes.containsKey(txtFieldNeckName.getText())) {
            txtFieldNeckName.setText("NAME ALREADY EXISTS!");                           // NOT SHOWING
            btnNeckInfoConfirm.disableProperty().setValue(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            txtFieldNeckName.clear();
            btnNeckInfoConfirm.disableProperty().setValue(false);
        } else if (txtFieldNeckName.getText().equals("")) {
            txtFieldNeckName.setText("NAME REQUIRED");                                  // NOT SHOWING
            btnNeckInfoConfirm.disableProperty().setValue(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            txtFieldNeckName.clear();
            btnNeckInfoConfirm.disableProperty().setValue(false);
        } else {
            accessories.put(txtFieldNeckName.getText(), new Accessories());

            accessories.get(txtFieldNeckName.getText()).setName(txtFieldNeckName.getText());
            accessories.get(txtFieldNeckName.getText()).setBrand(txtFieldNeckBrand.getText());
            accessories.get(txtFieldNeckName.getText()).setColor(txtFieldNeckColor.getText());
            accessories.get(txtFieldNeckName.getText()).setCategory(neckCategory.getValue());
            accessories.get(txtFieldNeckName.getText()).setImage(tempImage);

            ItemButton tempItemButton = new ItemButton(new ImageView(tempImage), txtFieldNeckName.getText());
            trackNeckItemGrid[trackNeckItems++] = tempItemButton.getName();

            neckItems.put(tempItemButton.getName(), tempItemButton.getButton());
            neckGrid.add(tempItemButton.getButton(), neckCurrentCol, neckCurrentRow);
            setGridMargins(tempItemButton.getButton());

            neckCurrentCol = trackNeckItems % neckMaxCol;
            neckCurrentRow = trackNeckItems / neckMaxCol;

            tempItemButton.getButton().setOnAction(event -> {
                neckShowInfoPane.setVisible(true);
                showNeckImg.setImage(accessories.get(tempItemButton.getName()).getImage());
                lblNeckName.setText(accessories.get(tempItemButton.getName()).getName());
                lblNeckBrand.setText(accessories.get(tempItemButton.getName()).getBrand());
                lblNeckColor.setText(accessories.get(tempItemButton.getName()).getColor());
                lblNeckCategory.setText(accessories.get(tempItemButton.getName()).getCategory());
                currNeckItem = accessories.get(tempItemButton.getName()).getName();
                neckGetInfoPane.setVisible(false);
            });

            if (!(neckCurrentRow == 4 && neckCurrentCol == 0)) {
                setBtnAddNeck(neckCurrentCol, neckCurrentRow);
            }

            neckGetInfoPane.setVisible(false);
            tempImage = null;
            clearControls();
        }
    }

    @FXML
    protected void removeNeckItem() {
        neckShowInfoPane.setVisible(false);

        int index = 0;

        for (int i = 0; i < trackNeckItems; i++) {
            if (trackNeckItemGrid[i].equals(currNeckItem)) {
                index = i;
                break;
            }
        }

        // Remove the button from the grid
        neckGrid.getChildren().remove(neckItems.get(currNeckItem));


        // Remove the item from tracking arrays and hash map
        trackNeckItemGrid[index] = null;
        neckItems.remove(currNeckItem);
        accessories.remove(currNeckItem);


        // Update the grid layout
        // Shift the remaining items in the tracking array
        for (int i = index; i < trackNeckItems - 1; i++) {
            trackNeckItemGrid[i] = trackNeckItemGrid[i + 1];

            neckGrid.getChildren().remove(neckItems.get(trackNeckItemGrid[i+1]));

            int newRow = i / neckMaxCol;
            int newCol = i % neckMaxCol;

            neckGrid.add(neckItems.get(trackNeckItemGrid[i]), newCol, newRow);

        }

        // Update the number of tracked items
        trackNeckItems--;

        neckCurrentCol = trackNeckItems % neckMaxCol;
        neckCurrentRow = trackNeckItems / neckMaxCol;

        // Reset the add button position
        setBtnAddNeck(neckCurrentCol, neckCurrentRow);

        clearControls();
    }


    // ---------- Neck Tab Functions END ----------


    // ---------- hand Tab Functions ----------

    private void setBtnAddHand(int col, int row) {
        btnAddHand.setVisible(true);

        btnAddHand.setMinWidth(Region.USE_COMPUTED_SIZE);
        btnAddHand.setMinHeight(Region.USE_COMPUTED_SIZE);
        btnAddHand.setPrefWidth(Region.USE_COMPUTED_SIZE);
        btnAddHand.setPrefHeight(Region.USE_COMPUTED_SIZE);
        btnAddHand.setMaxWidth(Region.USE_COMPUTED_SIZE);
        btnAddHand.setMaxHeight(Region.USE_COMPUTED_SIZE);


        handGrid.getChildren().remove(btnAddHand);
        handGrid.add(btnAddHand, col, row);
        setGridMargins(btnAddHand);
    }

    @FXML
    protected void btnAddHandClicked() {
        clearControls();
        handGetInfoPane.setVisible(true);
        tempHandImage.setImage(null);
    }

    @FXML
    protected void btnHandInfoConfirmClicked () {
        if (accessories.containsKey(txtFieldHandName.getText())) {
            txtFieldHandName.setText("NAME ALREADY EXISTS!");                           // NOT SHOWING
            btnHandInfoConfirm.disableProperty().setValue(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            txtFieldHandName.clear();
            btnHandInfoConfirm.disableProperty().setValue(false);
        } else if (txtFieldHandName.getText().equals("")) {
            txtFieldHandName.setText("NAME REQUIRED");                                  // NOT SHOWING
            btnHandInfoConfirm.disableProperty().setValue(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            txtFieldHandName.clear();
            btnHandInfoConfirm.disableProperty().setValue(false);
        } else {
            accessories.put(txtFieldHandName.getText(), new Accessories());

            accessories.get(txtFieldHandName.getText()).setName(txtFieldHandName.getText());
            accessories.get(txtFieldHandName.getText()).setBrand(txtFieldHandBrand.getText());
            accessories.get(txtFieldHandName.getText()).setColor(txtFieldHandColor.getText());
            accessories.get(txtFieldHandName.getText()).setCategory(handCategory.getValue());
            accessories.get(txtFieldHandName.getText()).setImage(tempImage);

            ItemButton tempItemButton = new ItemButton(new ImageView(tempImage), txtFieldHandName.getText());
            trackHandItemGrid[trackHandItems++] = tempItemButton.getName();

            handItems.put(tempItemButton.getName(), tempItemButton.getButton());
            handGrid.add(tempItemButton.getButton(), handCurrentCol, handCurrentRow);
            setGridMargins(tempItemButton.getButton());

            handCurrentCol = trackHandItems % handMaxCol;
            handCurrentRow = trackHandItems / handMaxCol;

            tempItemButton.getButton().setOnAction(event -> {
                handShowInfoPane.setVisible(true);
                showHandImg.setImage(accessories.get(tempItemButton.getName()).getImage());
                lblHandName.setText(accessories.get(tempItemButton.getName()).getName());
                lblHandBrand.setText(accessories.get(tempItemButton.getName()).getBrand());
                lblHandColor.setText(accessories.get(tempItemButton.getName()).getColor());
                lblHandCategory.setText(accessories.get(tempItemButton.getName()).getCategory());
                currHandItem = accessories.get(tempItemButton.getName()).getName();
                handGetInfoPane.setVisible(false);
            });

            if (!(handCurrentRow == 3 && handCurrentCol == 0)) {
                setBtnAddHand(handCurrentCol, handCurrentRow);
            }

            handGetInfoPane.setVisible(false);
            tempImage = null;
            clearControls();
        }
    }

    @FXML
    protected void removeHandItem() {
        handShowInfoPane.setVisible(false);

        int index = 0;

        for (int i = 0; i < trackHandItems; i++) {
            if (trackHandItemGrid[i].equals(currHandItem)) {
                index = i;
                break;
            }
        }

        // Remove the button from the grid
        handGrid.getChildren().remove(handItems.get(currHandItem));


        // Remove the item from tracking arrays and hash map
        trackHandItemGrid[index] = null;
        handItems.remove(currHandItem);
        accessories.remove(currHandItem);


        // Update the grid layout
        // Shift the remaining items in the tracking array
        for (int i = index; i < trackHandItems - 1; i++) {
            trackHandItemGrid[i] = trackHandItemGrid[i + 1];

            handGrid.getChildren().remove(handItems.get(trackHandItemGrid[i+1]));

            int newRow = i / handMaxCol;
            int newCol = i % handMaxCol;

            handGrid.add(handItems.get(trackHandItemGrid[i]), newCol, newRow);

        }

        // Update the number of tracked items
        trackHandItems--;

        handCurrentCol = trackHandItems % handMaxCol;
        handCurrentRow = trackHandItems / handMaxCol;

        // Reset the add button position
        setBtnAddHand(handCurrentCol, handCurrentRow);

        clearControls();
    }

    // ---------- hand Tab Functions END ----------



    // ---------- Outfit Creation ----------

    @FXML
    protected void backClicked() {
        mainTabPane.setVisible(true);
        titleLabel.setVisible(true);
        shadow.setVisible(true);
        btnShowOutfit.setVisible(true);
        btnCreateOutfit.setVisible(true);
        selectGenderPane.setVisible(false);
        outfitCreationPane.setVisible(false);
        outfitsPane.setVisible(false);
        pickItemPane.setVisible(false);
        pickItemScroll.setVvalue(0);
        itemsScroll.setVvalue(0);
    }

    @FXML
    protected void btnCreateOutfitClicked() {
        mainTabPane.setVisible(false);
        titleLabel.setVisible(false);
        shadow.setVisible(false);
        btnShowOutfit.setVisible(false);
        btnCreateOutfit.setVisible(false);
        selectGenderPane.setVisible(true);
        pickItemScroll.setVvalue(0);
    }

    @FXML
    protected void btnShowOutfitClicked() {
        mainTabPane.setVisible(false);
        titleLabel.setVisible(false);
        shadow.setVisible(false);
        btnShowOutfit.setVisible(false);
        btnCreateOutfit.setVisible(false);
        outfitsPane.setVisible(true);
    }

    @FXML
    protected void btnCreateMaleOutfit() {
        itemsScroll.setVvalue(0);
        selectGenderPane.setVisible(false);
        currGenderOutfitCreation = "Male";
        imgFigure.setImage(maleFigure);
        outfitCreationPane.setVisible(true);
    }

    @FXML
    protected void btnCreateFemaleOutfit() {
        itemsScroll.setVvalue(0);
        selectGenderPane.setVisible(false);
        currGenderOutfitCreation = "Female";
        imgFigure.setImage(femaleFigure);
        outfitCreationPane.setVisible(true);
    }


    @FXML
    protected void btnBackPick() {
        pickItemsGrid.getChildren().clear();
        pickItemPane.setVisible(false);
    }

    @FXML
    protected void btnPickHead() {
        if (trackHeadItems != 0) {
            pickItemPane.setVisible(true);
            currItemPick = "Head";
            labelPickItem.setText("HEAD ACCESSORIES");
            addPickItems(trackHeadItems, currItemPick);
        }
    }

    @FXML
    protected void btnPickNeck() {
        if (trackNeckItems != 0) {
            pickItemPane.setVisible(true);
            currItemPick = "Neck";
            labelPickItem.setText("NECK ACCESSORIES");
            addPickItems(trackNeckItems, currItemPick);
        }
    }

    @FXML
    protected void btnPickHand() {
        if (trackHandItems != 0) {
            pickItemPane.setVisible(true);
            currItemPick = "Hand";
            labelPickItem.setText("HAND ACCESSORIES");
            addPickItems(trackHandItems, currItemPick);
        }
    }

    @FXML
    protected void btnPickTop() {
        if (trackTopItems != 0) {
            pickItemPane.setVisible(true);
            currItemPick = "Top";
            labelPickItem.setText("TOPS");
            addPickItems(trackTopItems, currItemPick);
        }
    }

    @FXML
    protected void btnPickBot() {
        if (trackBotItems != 0) {
            pickItemPane.setVisible(true);
            currItemPick = "Bot";
            labelPickItem.setText("BOTTOMS");
            addPickItems(trackBotItems, currItemPick);
        }
    }

    @FXML
    protected void btnPickFoot() {
        if (trackFootItems != 0) {
            pickItemPane.setVisible(true);
            currItemPick = "Foot";
            labelPickItem.setText("FOOTWEARS");
            addPickItems(trackFootItems, currItemPick);
        }
    }

    protected void addPickItems(int count, String itemPick) {
        ItemButton tempItemButton;
        Button button;
        pickItemsGrid.getChildren().clear();
        for (int currentItem = 0; currentItem < count; currentItem++) {
            switch (itemPick) {
                case "Head":
                    tempItemButton = new ItemButton(new ImageView(accessories.get(trackHeadItemGrid[currentItem]).getImage()),
                    trackHeadItemGrid[currentItem]);
                    button = tempItemButton.getButton();
                    pickItemsGrid.add(button, currentItem, 0);
                    setGridMargins(button);
                    break;
                case "Neck":
                    tempItemButton = new ItemButton(new ImageView(accessories.get(trackNeckItemGrid[currentItem]).getImage()),
                    trackNeckItemGrid[currentItem]);
                    button = tempItemButton.getButton();
                    pickItemsGrid.add(button, currentItem, 0);
                    setGridMargins(button);
                    break;
                case "Hand":
                    tempItemButton = new ItemButton(new ImageView(accessories.get(trackHandItemGrid[currentItem]).getImage()),
                    trackHandItemGrid[currentItem]);
                    button = tempItemButton.getButton();
                    pickItemsGrid.add(button, currentItem, 0);
                    setGridMargins(button);
                    break;
                case "Top":
                    tempItemButton = new ItemButton(new ImageView(clothes.get(trackTopItemGrid[currentItem]).getImage()),
                    trackTopItemGrid[currentItem]);
                    button = tempItemButton.getButton();
                    pickItemsGrid.add(button, currentItem, 0);
                    setGridMargins(button);
                    break;
                case "Bot":
                    tempItemButton = new ItemButton(new ImageView(clothes.get(trackBotItemGrid[currentItem]).getImage()),
                    trackBotItemGrid[currentItem]);
                    button = tempItemButton.getButton();
                    pickItemsGrid.add(button, currentItem, 0);
                    setGridMargins(button);
                    break;
                case "Foot":
                    tempItemButton = new ItemButton(new ImageView(footwears.get(trackFootItemGrid[currentItem]).getImage()),
                    trackFootItemGrid[currentItem]);
                    button = tempItemButton.getButton();
                    pickItemsGrid.add(button, currentItem, 0);
                    setGridMargins(button);
                    break;
            }
        }



    }



    // ---------- Outfit Creation END ----------






    protected void setGridMargins(Node item) {
        GridPane.setMargin(item, new Insets(10));
        GridPane.setHalignment(item, HPos.CENTER);
        GridPane.setValignment(item, VPos.CENTER);
    }



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
            tempFootImage.setImage(tempImage);
            tempTopImage.setImage(tempImage);
            tempBotImage.setImage(tempImage);
            tempHeadImage.setImage(tempImage);
            tempNeckImage.setImage(tempImage);
            tempHandImage.setImage(tempImage);
        }
    }

    @FXML
    protected void clearControls() {
        if (tempImage != null) {
            tempFootImage.setImage(null);
            tempTopImage.setImage(null);
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
        if (txtFieldTopName != null) {
            txtFieldTopName.setText("");
        }
        if (txtFieldTopBrand != null) {
            txtFieldTopBrand.setText("");
        }
        if (txtFieldTopColor != null) {
            txtFieldTopColor.setText("");
        }
        if (topCategory != null) {
            topCategory.setValue("");
        }
        if (topShowInfoPane != null) {
            topShowInfoPane.setVisible(false);
        }
        if (topGetInfoPane != null) {
            topGetInfoPane.setVisible(false);
        }
        if (txtFieldBotName != null) {
            txtFieldBotName.setText("");
        }
        if (txtFieldBotBrand != null) {
            txtFieldBotBrand.setText("");
        }
        if (txtFieldBotColor != null) {
            txtFieldBotColor.setText("");
        }
        if (botCategory != null) {
            botCategory.setValue("");
        }
        if (botShowInfoPane != null) {
            botShowInfoPane.setVisible(false);
        }
        if (botGetInfoPane != null) {
            botGetInfoPane.setVisible(false);
        }
        if (txtFieldHeadName != null) {
            txtFieldHeadName.setText("");
        }
        if (txtFieldHeadBrand != null) {
            txtFieldHeadBrand.setText("");
        }
        if (txtFieldHeadColor != null) {
            txtFieldHeadColor.setText("");
        }
        if (headCategory != null) {
            headCategory.setValue("");
        }
        if (headShowInfoPane != null) {
            headShowInfoPane.setVisible(false);
        }
        if (headGetInfoPane != null) {
            headGetInfoPane.setVisible(false);
        }
        if (txtFieldNeckName != null) {
            txtFieldNeckName.setText("");
        }
        if (txtFieldNeckBrand != null) {
            txtFieldNeckBrand.setText("");
        }
        if (txtFieldNeckColor != null) {
            txtFieldNeckColor.setText("");
        }
        if (neckCategory != null) {
            neckCategory.setValue("");
        }
        if (neckShowInfoPane != null) {
            neckShowInfoPane.setVisible(false);
        }
        if (neckGetInfoPane != null) {
            neckGetInfoPane.setVisible(false);
        }
        if (txtFieldHandName != null) {
            txtFieldHandName.setText("");
        }
        if (txtFieldHandBrand != null) {
            txtFieldHandBrand.setText("");
        }
        if (txtFieldHandColor != null) {
            txtFieldHandColor.setText("");
        }
        if (handCategory != null) {
            handCategory.setValue("");
        }
        if (handShowInfoPane != null) {
            handShowInfoPane.setVisible(false);
        }
        if (handGetInfoPane != null) {
            handGetInfoPane.setVisible(false);
        }
    }



}
