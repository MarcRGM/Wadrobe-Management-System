package com.wardrobemanagementsystem;

import javafx.animation.PauseTransition;
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
import javafx.util.Duration;

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
    @FXML
    private Button btnOpt1, btnOpt2, btnOpt3, btnOpt4;


    // OUTFIT CREATION
    @FXML
    private Pane selectGenderPane, outfitCreationPane, outfitsPane, pickItemPane, removeInfoItemPane, wardrobeOption;

    @FXML
    private Button btnShowOutfit, btnCreateOutfit, currRemoveButton;

    @FXML
    private GridPane pickItemsGrid, pickHeadGrid, pickNeckGrid, pickHandGrid,
    pickTopGrid, pickBotGrid, pickFootGrid;

    private int headPickItems = 0;
    private int neckPickItems = 0;
    private int handPickItems = 0;
    private int topPickItems = 0;
    private int botPickItems = 0;
    private int footPickItems = 0;

    private String[] headItemsCreate = new String[2];
    private String[] neckItemsCreate = new String[2];
    private String[] handItemsCreate = new String[2];
    private String[] topItemsCreate = new String[2];
    private String[] botItemsCreate = new String[2];
    private String[] footItemsCreate = new String[2];

    private Button[] headItemsCreateButton = new Button[2];
    private Button[] neckItemsCreateButton = new Button[2];
    private Button[] handItemsCreateButton = new Button[2];
    private Button[] topItemsCreateButton = new Button[2];
    private Button[] botItemsCreateButton = new Button[2];
    private Button[] footItemsCreateButton = new Button[2];

    Image maleFigure = new Image(new File("src/main/java/com/icons8-body-600.png").toURI().toString());
    Image femaleFigure = new Image(new File("src/main/java/com/icons8-girl-body-600.png").toURI().toString());

    String currItemPick, currGenderOutfitCreation, currRemovePlace, currRemoveItem;

    @FXML
    private ImageView imgViewMale, imgViewFemale;

    @FXML
    private ImageView imgFigure;

    @FXML
    private ScrollPane itemsScroll, pickItemScroll;

    @FXML
    private Label labelPickItem, removeItemLabel;



    // Show Outfits

    String[] wardrobeSpace = new String[4];

    Outfit[] outfits = new Outfit[4];

    @FXML
    private GridPane showHeadGrid, showNeckGrid, showHandGrid,
    showTopGrid, showBotGrid, showFootGrid;

    @FXML
    private ScrollPane showOutfitItems;

    @FXML
    private Label lblCatOrMat, lblShowItem, lblShowName, lblShowBrand, lblShowColor, lblShowCatOrMat;

    @FXML
    private Pane showInfoPane;

    // space 1
    String[] tempHead1 = headItemsCreate;
    String[] tempNeck1 = neckItemsCreate;
    String[] tempHand1 = handItemsCreate;
    String[] tempTop1 = topItemsCreate;
    String[] tempBot1 = botItemsCreate;
    String[] tempFoot1 = footItemsCreate;

    // space 2
    String[] tempHead2 = headItemsCreate;
    String[] tempNeck2 = neckItemsCreate;
    String[] tempHand2 = handItemsCreate;
    String[] tempTop2 = topItemsCreate;
    String[] tempBot2 = botItemsCreate;
    String[] tempFoot2 = footItemsCreate;

    // space 3
    String[] tempHead3 = headItemsCreate;
    String[] tempNeck3 = neckItemsCreate;
    String[] tempHand3 = handItemsCreate;
    String[] tempTop3 = topItemsCreate;
    String[] tempBot3 = botItemsCreate;
    String[] tempFoot3 = footItemsCreate;

    // space 4
    String[] tempHead4 = headItemsCreate;
    String[] tempNeck4 = neckItemsCreate;
    String[] tempHand4 = handItemsCreate;
    String[] tempTop4 = topItemsCreate;
    String[] tempBot4 = botItemsCreate;
    String[] tempFoot4 = footItemsCreate;

    int currOutfitClicked;



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
            txtFieldTopName.setText("NAME ALREADY EXISTS!");
            btnTopInfoConfirm.disableProperty().setValue(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                txtFieldTopName.clear();
                btnTopInfoConfirm.setDisable(false);
            });
            pause.play();
        } else if (txtFieldTopName.getText().equals("")) {
            txtFieldTopName.setText("NAME REQUIRED");
            btnTopInfoConfirm.disableProperty().setValue(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                txtFieldTopName.clear();
                btnTopInfoConfirm.setDisable(false);
            });
            pause.play();
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
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                txtFieldBotName.clear();
                btnBotInfoConfirm.setDisable(false);
            });
            pause.play();;
        } else if (txtFieldBotName.getText().equals("")) {
            txtFieldBotName.setText("NAME REQUIRED");                                  // NOT SHOWING
            btnBotInfoConfirm.disableProperty().setValue(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                txtFieldBotName.clear();
                btnBotInfoConfirm.setDisable(false);
            });
            pause.play();;
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
            txtFieldFootName.setText("NAME ALREADY EXISTS!");
            btnFootInfoConfirm.disableProperty().setValue(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                txtFieldFootName.clear();
                btnFootInfoConfirm.setDisable(false);
            });
            pause.play();
        } else if (txtFieldFootName.getText().equals("")) {
            txtFieldFootName.setText("NAME REQUIRED");
            btnFootInfoConfirm.disableProperty().setValue(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                txtFieldFootName.clear();
                btnFootInfoConfirm.setDisable(false);
            });
            pause.play();
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
            txtFieldHeadName.setText("NAME ALREADY EXISTS!");
            btnHeadInfoConfirm.disableProperty().setValue(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                txtFieldHeadName.clear();
                btnHeadInfoConfirm.setDisable(false);
            });
            pause.play();
        } else if (txtFieldHeadName.getText().equals("")) {
            txtFieldHeadName.setText("NAME REQUIRED");
            btnHeadInfoConfirm.disableProperty().setValue(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                txtFieldHeadName.clear();
                btnHeadInfoConfirm.setDisable(false);
            });
            pause.play();
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
            txtFieldNeckName.setText("NAME ALREADY EXISTS!");
            btnNeckInfoConfirm.disableProperty().setValue(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                txtFieldNeckName.clear();
                btnNeckInfoConfirm.setDisable(false);
            });
            pause.play();
        } else if (txtFieldNeckName.getText().equals("")) {
            txtFieldNeckName.setText("NAME REQUIRED");
            btnNeckInfoConfirm.disableProperty().setValue(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                txtFieldNeckName.clear();
                btnNeckInfoConfirm.setDisable(false);
            });
            pause.play();
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
            txtFieldHandName.setText("NAME ALREADY EXISTS!");
            btnHandInfoConfirm.disableProperty().setValue(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                txtFieldHandName.clear();
                btnHandInfoConfirm.setDisable(false);
            });
            pause.play();
        } else if (txtFieldHandName.getText().equals("")) {
            txtFieldHandName.setText("NAME REQUIRED");
            btnHandInfoConfirm.disableProperty().setValue(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                txtFieldHandName.clear();
                btnHandInfoConfirm.setDisable(false);
            });
            pause.play();
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
        pickItemScroll.setHvalue(0);
        itemsScroll.setVvalue(0);
        pickHeadGrid.getChildren().clear();
        pickNeckGrid.getChildren().clear();
        pickHandGrid.getChildren().clear();
        pickTopGrid.getChildren().clear();
        pickBotGrid.getChildren().clear();
        pickFootGrid.getChildren().clear();
        wardrobeOption.setVisible(false);
        headPickItems = 0;
        neckPickItems = 0;
        handPickItems = 0;
        topPickItems = 0;
        botPickItems = 0;
        footPickItems = 0;
        headItemsCreate = new String[2];
        neckItemsCreate = new String[2];
        handItemsCreate = new String[2];
        topItemsCreate = new String[2];
        botItemsCreate = new String[2];
        footItemsCreate = new String[2];
    }

    @FXML
    protected void btnCreateOutfitClicked() {
        titleLabel.setVisible(false);
        shadow.setVisible(false);
        selectGenderPane.setVisible(true);
        pickItemScroll.setHvalue(0);
    }

    @FXML
    protected void btnShowOutfitClicked() {
        titleLabel.setVisible(false);
        shadow.setVisible(false);
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
        pickItemScroll.setHvalue(0);
    }

    @FXML
    protected void btnPickHead() {
        if (trackHeadItems != 0 && headPickItems != 2) {
            pickItemPane.setVisible(true);
            currItemPick = "Head";
            labelPickItem.setText("HEAD ACCESSORIES");
            addPickItems(trackHeadItems, currItemPick);
            pickItemScroll.setHvalue(0);
        }
    }

    @FXML
    protected void btnPickNeck() {
        if (trackNeckItems != 0 && neckPickItems != 2) {
            pickItemPane.setVisible(true);
            currItemPick = "Neck";
            labelPickItem.setText("NECK ACCESSORIES");
            addPickItems(trackNeckItems, currItemPick);
            pickItemScroll.setHvalue(0);
        }
    }

    @FXML
    protected void btnPickHand() {
        if (trackHandItems != 0 && handPickItems != 2) {
            pickItemPane.setVisible(true);
            currItemPick = "Hand";
            labelPickItem.setText("HAND ACCESSORIES");
            addPickItems(trackHandItems, currItemPick);
            pickItemScroll.setHvalue(0);
        }
    }

    @FXML
    protected void btnPickTop() {
        if (trackTopItems != 0 && topPickItems != 2) {
            pickItemPane.setVisible(true);
            currItemPick = "Top";
            labelPickItem.setText("TOPS");
            addPickItems(trackTopItems, currItemPick);
            pickItemScroll.setHvalue(0);
        }
    }

    @FXML
    protected void btnPickBot() {
        if (trackBotItems != 0 && botPickItems != 2) {
            pickItemPane.setVisible(true);
            currItemPick = "Bot";
            labelPickItem.setText("BOTTOMS");
            addPickItems(trackBotItems, currItemPick);
            pickItemScroll.setHvalue(0);
        }
    }

    @FXML
    protected void btnPickFoot() {
        if (trackFootItems != 0 && footPickItems != 2) {
            pickItemPane.setVisible(true);
            currItemPick = "Foot";
            labelPickItem.setText("FOOTWEARS");
            addPickItems(trackFootItems, currItemPick);
            pickItemScroll.setHvalue(0);
        }
    }

    protected void addPickItems(int count, String itemPick) {
        ItemButton tempItemButton1;
        Button button1;
        pickItemsGrid.getChildren().clear();

        for (int currentItem = 0; currentItem < count; currentItem++) {
            switch (itemPick) {
                case "Head":
                    tempItemButton1 = new ItemButton(new ImageView(accessories.get(trackHeadItemGrid[ currentItem ]).getImage()),
                            trackHeadItemGrid[ currentItem ]);
                    button1 = tempItemButton1.getButton();
                    pickItemsGrid.add(button1, currentItem, 0);
                    setGridMargins(button1);

                    for (String item : headItemsCreate) {
                        if (item != null &&
                                item.equals(trackHeadItemGrid[ currentItem ])) {
                            break;
                        }
                        int headCurrentItem = currentItem;
                        button1.setOnAction(event -> {
                            pickItemScroll.setHvalue(0);
                            Button clickedButton = (Button) event.getSource();
                            clickedButton.setDisable(true);

                            if (headPickItems != 2) {
                                headItemsCreate[ headPickItems ] = trackHeadItemGrid[ headCurrentItem ];
                                ItemButton tempItemButton2 = new ItemButton(new ImageView(accessories
                                        .get(trackHeadItemGrid[ headCurrentItem ]).getImage()),
                                        trackHeadItemGrid[ headCurrentItem ]);
                                tempItemButton2.setImageViewSize(100, 100);
                                Button button2 = tempItemButton2.getButton();
                                headItemsCreateButton[ headPickItems ] = button2;
                                button2.setMinWidth(125);
                                button2.setMaxWidth(125);
                                button2.setPrefWidth(125);
                                button2.setMinHeight(125);
                                button2.setMaxHeight(125);
                                button2.setPrefHeight(125);

                                button2.setOnAction(e -> {
                                    removeInfoItemPane.setVisible(true);
                                    removeItemLabel.setText(trackHeadItemGrid[ headCurrentItem ]);
                                    currRemoveItem = trackHeadItemGrid[ headCurrentItem ];
                                    currRemovePlace = "Head";
                                    currRemoveButton = button2;
                                    pickItemPane.setVisible(false);
                                    pickItemScroll.setHvalue(0);
                                });


                                pickHeadGrid.add(button2, headPickItems++, 0);
                                setGridMargins(button2);


                                if (headPickItems == 2) {
                                    pickItemPane.setVisible(false);
                                }
                            }
                        });
                        break;
                    }
                    break;
                case "Neck":
                    tempItemButton1 = new ItemButton(new ImageView(accessories.get(trackNeckItemGrid[ currentItem ]).getImage()),
                            trackNeckItemGrid[ currentItem ]);
                    button1 = tempItemButton1.getButton();
                    pickItemsGrid.add(button1, currentItem, 0);
                    setGridMargins(button1);

                    for (String item : neckItemsCreate) {
                        if (item != null &&
                                item.equals(trackNeckItemGrid[ currentItem ])) {
                            break;
                        }
                        int neckCurrentItem = currentItem;
                        button1.setOnAction(event -> {
                            pickItemScroll.setHvalue(0);
                            Button clickedButton = (Button) event.getSource();
                            clickedButton.setDisable(true);
                            if (neckPickItems != 2) {
                                neckItemsCreate[ neckPickItems ] = trackNeckItemGrid[ neckCurrentItem ];
                                ItemButton tempItemButton2 = new ItemButton(new ImageView(accessories
                                        .get(trackNeckItemGrid[ neckCurrentItem ]).getImage()),
                                        trackNeckItemGrid[ neckCurrentItem ]);
                                tempItemButton2.setImageViewSize(100, 100);
                                Button button2 = tempItemButton2.getButton();
                                neckItemsCreateButton[ neckPickItems ] = button2;
                                button2.setMinWidth(125);
                                button2.setMaxWidth(125);
                                button2.setPrefWidth(125);
                                button2.setMinHeight(125);
                                button2.setMaxHeight(125);
                                button2.setPrefHeight(125);

                                button2.setOnAction(e -> {
                                    removeInfoItemPane.setVisible(true);
                                    removeItemLabel.setText(trackNeckItemGrid[ neckCurrentItem ]);
                                    currRemoveItem = trackNeckItemGrid[ neckCurrentItem ];
                                    currRemovePlace = "Neck";
                                    currRemoveButton = button2;
                                    pickItemPane.setVisible(false);
                                    pickItemScroll.setHvalue(0);
                                });

                                pickNeckGrid.add(button2, neckPickItems++, 0);
                                setGridMargins(button2);

                                if (neckPickItems == 2) {
                                    pickItemPane.setVisible(false);
                                }
                            }
                        });
                        break;
                    }
                    break;
                case "Hand":
                    tempItemButton1 = new ItemButton(new ImageView(accessories.get(trackHandItemGrid[ currentItem ]).getImage()),
                            trackHandItemGrid[ currentItem ]);
                    button1 = tempItemButton1.getButton();
                    pickItemsGrid.add(button1, currentItem, 0);
                    setGridMargins(button1);

                    for (String item : handItemsCreate) {
                        if (item != null &&
                                item.equals(trackHandItemGrid[ currentItem ])) {
                            break;
                        }
                        int handCurrentItem = currentItem;
                        button1.setOnAction(event -> {
                            pickItemScroll.setHvalue(0);
                            Button clickedButton = (Button) event.getSource();
                            clickedButton.setDisable(true);
                            if (handPickItems != 2) {
                                handItemsCreate[ handPickItems ] = trackHandItemGrid[ handCurrentItem ];
                                ItemButton tempItemButton2 = new ItemButton(new ImageView(accessories
                                        .get(trackHandItemGrid[ handCurrentItem ]).getImage()),
                                        trackHandItemGrid[ handCurrentItem ]);
                                tempItemButton2.setImageViewSize(100, 100);
                                Button button2 = tempItemButton2.getButton();
                                handItemsCreateButton[ handPickItems ] = button2;
                                button2.setMinWidth(125);
                                button2.setMaxWidth(125);
                                button2.setPrefWidth(125);
                                button2.setMinHeight(125);
                                button2.setMaxHeight(125);
                                button2.setPrefHeight(125);

                                button2.setOnAction(e -> {
                                    removeInfoItemPane.setVisible(true);
                                    removeItemLabel.setText(trackHandItemGrid[ handCurrentItem ]);
                                    currRemoveItem = trackHandItemGrid[ handCurrentItem ];
                                    currRemovePlace = "Hand";
                                    currRemoveButton = button2;
                                    pickItemPane.setVisible(false);
                                    pickItemScroll.setHvalue(0);
                                });

                                pickHandGrid.add(button2, handPickItems++, 0);
                                setGridMargins(button2);

                                if (handPickItems == 2) {
                                    pickItemPane.setVisible(false);
                                }
                            }
                        });
                        break;
                    }
                    break;
                case "Top":
                    tempItemButton1 = new ItemButton(new ImageView(clothes.get(trackTopItemGrid[ currentItem ]).getImage()),
                            trackTopItemGrid[ currentItem ]);
                    button1 = tempItemButton1.getButton();
                    pickItemsGrid.add(button1, currentItem, 0);
                    setGridMargins(button1);

                    for (String item : topItemsCreate) {
                        if (item != null &&
                                item.equals(trackTopItemGrid[ currentItem ])) {
                            break;
                        }
                        int topCurrentItem = currentItem;
                        button1.setOnAction(event -> {
                            pickItemScroll.setHvalue(0);
                            Button clickedButton = (Button) event.getSource();
                            clickedButton.setDisable(true);
                            if (topPickItems != 2) {
                                topItemsCreate[ topPickItems ] = trackTopItemGrid[ topCurrentItem ];
                                ItemButton tempItemButton2 = new ItemButton(new ImageView(clothes
                                        .get(trackTopItemGrid[ topCurrentItem ]).getImage()),
                                        trackTopItemGrid[ topCurrentItem ]);
                                tempItemButton2.setImageViewSize(100, 100);
                                Button button2 = tempItemButton2.getButton();
                                topItemsCreateButton[ topPickItems ] = button2;
                                button2.setMinWidth(125);
                                button2.setMaxWidth(125);
                                button2.setPrefWidth(125);
                                button2.setMinHeight(125);
                                button2.setMaxHeight(125);
                                button2.setPrefHeight(125);

                                button2.setOnAction(e -> {
                                    removeInfoItemPane.setVisible(true);
                                    removeItemLabel.setText(trackTopItemGrid[ topCurrentItem ]);
                                    currRemoveItem = trackTopItemGrid[ topCurrentItem ];
                                    currRemovePlace = "Top";
                                    currRemoveButton = button2;
                                    pickItemPane.setVisible(false);
                                    pickItemScroll.setHvalue(0);
                                });

                                pickTopGrid.add(button2, topPickItems++, 0);
                                setGridMargins(button2);

                                if (topPickItems == 2) {
                                    pickItemPane.setVisible(false);
                                }
                            }
                        });
                        break;
                    }
                    break;
                case "Bot":
                    tempItemButton1 = new ItemButton(new ImageView(clothes.get(trackBotItemGrid[ currentItem ]).getImage()),
                            trackBotItemGrid[ currentItem ]);
                    button1 = tempItemButton1.getButton();
                    pickItemsGrid.add(button1, currentItem, 0);
                    setGridMargins(button1);

                    for (String item : botItemsCreate) {
                        if (item != null &&
                                item.equals(trackBotItemGrid[ currentItem ])) {
                            break;
                        }
                        int botCurrentItem = currentItem;
                        button1.setOnAction(event -> {
                            pickItemScroll.setHvalue(0);
                            Button clickedButton = (Button) event.getSource();
                            clickedButton.setDisable(true);
                            if (botPickItems != 2) {
                                botItemsCreate[ botPickItems ] = trackBotItemGrid[ botCurrentItem ];
                                ItemButton tempItemButton2 = new ItemButton(new ImageView(clothes
                                        .get(trackBotItemGrid[ botCurrentItem ]).getImage()),
                                        trackBotItemGrid[ botCurrentItem ]);
                                tempItemButton2.setImageViewSize(100, 100);
                                Button button2 = tempItemButton2.getButton();
                                botItemsCreateButton[ botPickItems ] = button2;
                                button2.setMinWidth(125);
                                button2.setMaxWidth(125);
                                button2.setPrefWidth(125);
                                button2.setMinHeight(125);
                                button2.setMaxHeight(125);
                                button2.setPrefHeight(125);

                                button2.setOnAction(e -> {
                                    removeInfoItemPane.setVisible(true);
                                    removeItemLabel.setText(trackBotItemGrid[ botCurrentItem ]);
                                    currRemoveItem = trackBotItemGrid[ botCurrentItem ];
                                    currRemovePlace = "Bot";
                                    currRemoveButton = button2;
                                    pickItemPane.setVisible(false);
                                    pickItemScroll.setHvalue(0);
                                });

                                pickBotGrid.add(button2, botPickItems++, 0);
                                setGridMargins(button2);

                                if (botPickItems == 2) {
                                    pickItemPane.setVisible(false);
                                }
                            }
                        });
                        break;
                    }
                    break;
                case "Foot":
                    tempItemButton1 = new ItemButton(new ImageView(footwears.get(trackFootItemGrid[ currentItem ]).getImage()),
                            trackFootItemGrid[ currentItem ]);
                    button1 = tempItemButton1.getButton();
                    pickItemsGrid.add(button1, currentItem, 0);
                    setGridMargins(button1);

                    for (String item : footItemsCreate) {
                        if (item != null &&
                                item.equals(trackFootItemGrid[ currentItem ])) {
                            break;
                        }
                        int footCurrentItem = currentItem;
                        button1.setOnAction(event -> {
                            pickItemScroll.setHvalue(0);
                            Button clickedButton = (Button) event.getSource();
                            clickedButton.setDisable(true);
                            if (footPickItems != 2) {
                                footItemsCreate[ footPickItems ] = trackFootItemGrid[ footCurrentItem ];
                                ItemButton tempItemButton2 = new ItemButton(new ImageView(footwears
                                        .get(trackFootItemGrid[ footCurrentItem ]).getImage()),
                                        trackFootItemGrid[ footCurrentItem ]);
                                tempItemButton2.setImageViewSize(100, 100);
                                Button button2 = tempItemButton2.getButton();
                                footItemsCreateButton[ footPickItems ] = button2;
                                button2.setMinWidth(125);
                                button2.setMaxWidth(125);
                                button2.setPrefWidth(125);
                                button2.setMinHeight(125);
                                button2.setMaxHeight(125);
                                button2.setPrefHeight(125);

                                button2.setOnAction(e -> {
                                    removeInfoItemPane.setVisible(true);
                                    removeItemLabel.setText(trackFootItemGrid[ footCurrentItem ]);
                                    currRemoveItem = trackFootItemGrid[ footCurrentItem ];
                                    currRemovePlace = "Foot";
                                    currRemoveButton = button2;
                                    pickItemPane.setVisible(false);
                                    pickItemScroll.setHvalue(0);
                                });

                                pickFootGrid.add(button2, footPickItems++, 0);
                                setGridMargins(button2);

                                if (footPickItems == 2) {
                                    pickItemPane.setVisible(false);
                                }
                            }
                        });
                        break;
                    }
                    break;
            }
        }
    }

    @FXML
    protected void noRemoveClicked() {
        removeInfoItemPane.setVisible(false);
    }

    @FXML
    protected void yesRemoveClicked() {
        switch (currRemovePlace) {
            case "Head":
                pickHeadGrid.getChildren().remove(currRemoveButton);
                for (int i = 0; i < headPickItems; i++) {
                    if (headItemsCreate[i] != null && headItemsCreate[i].equals(currRemoveItem)) {
                        headItemsCreate[i] = null;
                        if (i == 0 && headPickItems > 1) {
                            headItemsCreate[i] = headItemsCreate[i+1];
                            headItemsCreate[i+1] = null;
                            Button nextButton = headItemsCreateButton[i+1];
                            pickHeadGrid.getChildren().remove(nextButton);
                            pickHeadGrid.add(nextButton, 0, 0);
                            headItemsCreateButton[i] = nextButton;
                            headItemsCreateButton[i+1] = null;
                        } else {
                            headItemsCreateButton[i] = null;
                        }
                        break;
                    }
                }
                headPickItems--;
                break;
            case "Neck":
                pickNeckGrid.getChildren().remove(currRemoveButton);
                for (int i = 0; i < neckPickItems; i++) {
                    if (neckItemsCreate[i] != null && neckItemsCreate[i].equals(currRemoveItem)) {
                        neckItemsCreate[i] = null;
                        if (i == 0 && neckPickItems > 1) {
                            neckItemsCreate[i] = neckItemsCreate[i+1];
                            neckItemsCreate[i+1] = null;
                            Button nextButton = neckItemsCreateButton[i+1];
                            pickNeckGrid.getChildren().remove(nextButton);
                            pickNeckGrid.add(nextButton, 0, 0);
                            neckItemsCreateButton[i] = nextButton;
                            neckItemsCreateButton[i+1] = null;
                        } else {
                            neckItemsCreateButton[i] = null;
                        }
                        break;
                    }
                }
                neckPickItems--;
                break;
            case "Hand":
                pickHandGrid.getChildren().remove(currRemoveButton);
                for (int i = 0; i < handPickItems; i++) {
                    if (handItemsCreate[i] != null && handItemsCreate[i].equals(currRemoveItem)) {
                        handItemsCreate[i] = null;
                        if (i == 0 && handPickItems > 1) {
                            handItemsCreate[i] = handItemsCreate[i+1];
                            handItemsCreate[i+1] = null;
                            Button nextButton = handItemsCreateButton[i+1];
                            pickHandGrid.getChildren().remove(nextButton);
                            pickHandGrid.add(nextButton, 0, 0);
                            handItemsCreateButton[i] = nextButton;
                            handItemsCreateButton[i+1] = null;
                        } else {
                            handItemsCreateButton[i] = null;
                        }
                        break;
                    }
                }
                handPickItems--;
                break;
            case "Top":
                pickTopGrid.getChildren().remove(currRemoveButton);
                for (int i = 0; i < topPickItems; i++) {
                    if (topItemsCreate[i] != null && topItemsCreate[i].equals(currRemoveItem)) {
                        topItemsCreate[i] = null;
                        if (i == 0 && topPickItems > 1) {
                            topItemsCreate[i] = topItemsCreate[i+1];
                            topItemsCreate[i+1] = null;
                            Button nextButton = topItemsCreateButton[i+1];
                            pickTopGrid.getChildren().remove(nextButton);
                            pickTopGrid.add(nextButton, 0, 0);
                            topItemsCreateButton[i] = nextButton;
                            topItemsCreateButton[i+1] = null;
                        } else {
                            topItemsCreateButton[i] = null;
                        }
                        break;
                    }
                }
                topPickItems--;
                break;
            case "bot":
                pickBotGrid.getChildren().remove(currRemoveButton);
                for (int i = 0; i < botPickItems; i++) {
                    if (botItemsCreate[i] != null && botItemsCreate[i].equals(currRemoveItem)) {
                        botItemsCreate[i] = null;
                        if (i == 0 && botPickItems > 1) {
                            botItemsCreate[i] = botItemsCreate[i+1];
                            botItemsCreate[i+1] = null;
                            Button nextButton = botItemsCreateButton[i+1];
                            pickBotGrid.getChildren().remove(nextButton);
                            pickBotGrid.add(nextButton, 0, 0);
                            botItemsCreateButton[i] = nextButton;
                            botItemsCreateButton[i+1] = null;
                        } else {
                            botItemsCreateButton[i] = null;
                        }
                        break;
                    }
                }
                botPickItems--;
                break;
            case "Foot":
                pickFootGrid.getChildren().remove(currRemoveButton);
                for (int i = 0; i < footPickItems; i++) {
                    if (footItemsCreate[i] != null && footItemsCreate[i].equals(currRemoveItem)) {
                        footItemsCreate[i] = null;
                        if (i == 0 && footPickItems > 1) {
                            footItemsCreate[i] = footItemsCreate[i+1];
                            footItemsCreate[i+1] = null;
                            Button nextButton = footItemsCreateButton[i+1];
                            pickFootGrid.getChildren().remove(nextButton);
                            pickFootGrid.add(nextButton, 0, 0);
                            footItemsCreateButton[i] = nextButton;
                            footItemsCreateButton[i+1] = null;
                        } else {
                            footItemsCreateButton[i] = null;
                        }
                        break;
                    }
                }
                footPickItems--;
                break;
        }
        removeInfoItemPane.setVisible(false);
    }

    @FXML
    protected void btnAddOutfit() {
        wardrobeOption.setVisible(true);
    }

    @FXML
    protected void btnBackOptionClicked() {
        wardrobeOption.setVisible(false);
    }

    @FXML
    protected void space1Clicked() {
        wardrobeOption.setVisible(false);
        btnOpt1.setDisable(true);
        outfits[0] = new Outfit();

        tempHead1 = headItemsCreate;
        tempNeck1 = neckItemsCreate;
        tempHand1 = handItemsCreate;
        tempTop1 = topItemsCreate;
        tempBot1 = botItemsCreate;
        tempFoot1 = footItemsCreate;

        clearSelections();
        resetItemCreationArrays();
        clearAndInitializeGrids();

        wardrobeOption.setVisible(false);
    }


    @FXML
    protected void space2Clicked() {
        wardrobeOption.setVisible(false);
        btnOpt2.setDisable(true);
        outfits[1] = new Outfit();

        tempHead2 = headItemsCreate;
        tempNeck2 = neckItemsCreate;
        tempHand2 = handItemsCreate;
        tempTop2 = topItemsCreate;
        tempBot2 = botItemsCreate;
        tempFoot2 = footItemsCreate;

        clearSelections();
        resetItemCreationArrays();
        clearAndInitializeGrids();

        wardrobeOption.setVisible(false);
    }



    @FXML
    protected void space3Clicked() {
        wardrobeOption.setVisible(false);
        btnOpt3.setDisable(true);
        outfits[2] = new Outfit();

        tempHead3 = headItemsCreate;
        tempNeck3 = neckItemsCreate;
        tempHand3 = handItemsCreate;
        tempTop3 = topItemsCreate;
        tempBot3 = botItemsCreate;
        tempFoot3 = footItemsCreate;

        clearSelections();
        resetItemCreationArrays();
        clearAndInitializeGrids();

        System.out.println(headItemsCreate[0]);

        wardrobeOption.setVisible(false);
    }


    @FXML
    protected void space4Clicked() {
        wardrobeOption.setVisible(false);
        btnOpt4.setDisable(true);
        outfits[3] = new Outfit();

        tempHead4 = headItemsCreate;
        tempNeck4 = neckItemsCreate;
        tempHand4 = handItemsCreate;
        tempTop4 = topItemsCreate;
        tempBot4 = botItemsCreate;
        tempFoot4 = footItemsCreate;

        clearSelections();
        resetItemCreationArrays();
        clearAndInitializeGrids();

        wardrobeOption.setVisible(false);
    }


    private void clearSelections() {
        headPickItems = 0;
        neckPickItems = 0;
        handPickItems = 0;
        topPickItems = 0;
        botPickItems = 0;
        footPickItems = 0;
    }

    private void resetItemCreationArrays() {
        headItemsCreate = new String[2];
        neckItemsCreate = new String[2];
        handItemsCreate = new String[2];
        topItemsCreate = new String[2];
        botItemsCreate = new String[2];
        footItemsCreate = new String[2];
    }

    private void clearAndInitializeGrids() {
        pickHeadGrid.getChildren().clear();
        pickNeckGrid.getChildren().clear();
        pickHandGrid.getChildren().clear();
        pickTopGrid.getChildren().clear();
        pickBotGrid.getChildren().clear();
        pickFootGrid.getChildren().clear();
    }

    @FXML
    protected void backShowItemInfo() {
        showInfoPane.setVisible(false);
    }

    // ---------- Outfit Creation END ----------






    // ---------- Show Outfits ----------


    @FXML
    protected void btnBackOutfitClicked() {
        showOutfitItems.setVisible(false);
        showOutfitItems.setVvalue(0);
        clearOutfitShowGrids();
    }

    private void clearOutfitShowGrids() {
        showHeadGrid.getChildren().clear();
        showNeckGrid.getChildren().clear();
        showHandGrid.getChildren().clear();
        showTopGrid.getChildren().clear();
        showBotGrid.getChildren().clear();
        showFootGrid.getChildren().clear();
    }

    @FXML
    protected void btnBackShowClicked() {
        clearOutfitShowGrids();
        showOutfitItems.setVisible(false);
        outfitsPane.setVisible(false);
    }


    @FXML
    protected void outfit1Clicked() {
        currOutfitClicked = 0;

        if (outfits[0] != null) {
            showOutfitItems.setVisible(true);
            for (int i = 0; i < tempHead1.length; i++){
                if (tempHead1[i] != null) {
                    outfits[0].setHeadAcc(accessories.get(tempHead1[i]), i);
                    Accessories tempHeadAcc = outfits[0].getHeadAcc(i);
                    ItemButton headItemButton = new ItemButton(new ImageView(tempHeadAcc.getImage()),
                                tempHeadAcc.getName());
                    headItemButton.setImageViewSize(100, 100);
                    Button buttonHead = headItemButton.getButton();
                    buttonHead.setMinWidth(125);
                    buttonHead.setMaxWidth(125);
                    buttonHead.setPrefWidth(125);
                    buttonHead.setMinHeight(125);
                    buttonHead.setMaxHeight(125);
                    buttonHead.setPrefHeight(125);


                    buttonHead.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Head Accessory");
                        lblShowName.setText(tempHeadAcc.getName());
                        lblShowBrand.setText(tempHeadAcc.getBrand());
                        lblShowColor.setText(tempHeadAcc.getColor());
                        lblCatOrMat.setText("Material");
                        lblShowCatOrMat.setText(tempHeadAcc.getCategory());
                    });

                    showHeadGrid.add(buttonHead, i, 0);
                    setGridMargins(buttonHead);
                }
            }

            for (int i = 0; i < tempNeck1.length; i++){
                if (tempNeck1[i] != null) {
                    outfits[0].setNeckAcc(accessories.get(tempNeck1[i]), i);
                    Accessories tempNeckAcc = outfits[0].getNeckAcc(i);
                    ItemButton neckItemButton = new ItemButton(new ImageView(tempNeckAcc.getImage()),
                            tempNeckAcc.getName());
                    neckItemButton.setImageViewSize(100, 100);
                    Button buttonNeck = neckItemButton.getButton();
                    buttonNeck.setMinWidth(125);
                    buttonNeck.setMaxWidth(125);
                    buttonNeck.setPrefWidth(125);
                    buttonNeck.setMinHeight(125);
                    buttonNeck.setMaxHeight(125);
                    buttonNeck.setPrefHeight(125);


                    buttonNeck.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Neck Accessory");
                        lblShowName.setText(tempNeckAcc.getName());
                        lblShowBrand.setText(tempNeckAcc.getBrand());
                        lblShowColor.setText(tempNeckAcc.getColor());
                        lblCatOrMat.setText("Material");
                        lblShowCatOrMat.setText(tempNeckAcc.getCategory());
                    });

                    showNeckGrid.add(buttonNeck, i, 0);
                    setGridMargins(buttonNeck);
                }
            }

            for (int i = 0; i < tempHand1.length; i++){
                if (tempHand1[i] != null) {
                    outfits[0].setHandAcc(accessories.get(tempHand1[i]), i);
                    Accessories tempHandAcc = outfits[0].getHandAcc(i);
                    ItemButton handItemButton = new ItemButton(new ImageView(tempHandAcc.getImage()),
                            tempHandAcc.getName());
                    handItemButton.setImageViewSize(100, 100);
                    Button buttonHand = handItemButton.getButton();
                    buttonHand.setMinWidth(125);
                    buttonHand.setMaxWidth(125);
                    buttonHand.setPrefWidth(125);
                    buttonHand.setMinHeight(125);
                    buttonHand.setMaxHeight(125);
                    buttonHand.setPrefHeight(125);


                    buttonHand.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Hand Accessory");
                        lblShowName.setText(tempHandAcc.getName());
                        lblShowBrand.setText(tempHandAcc.getBrand());
                        lblShowColor.setText(tempHandAcc.getColor());
                        lblCatOrMat.setText("Material:");
                        lblShowCatOrMat.setText(tempHandAcc.getCategory());
                    });

                    showHandGrid.add(buttonHand, i, 0);
                    setGridMargins(buttonHand);
                }
            }

            for (int i = 0; i < tempTop1.length; i++){
                if (tempTop1[i] != null) {
                    outfits[0].setTopCloth(clothes.get(tempTop1[i]), i);
                    Clothing tempTopCloth = outfits[0].getTopClothes(i);
                    ItemButton topItemButton = new ItemButton(new ImageView(tempTopCloth.getImage()),
                            tempTopCloth.getName());
                    topItemButton.setImageViewSize(100, 100);
                    Button buttonTop = topItemButton.getButton();
                    buttonTop.setMinWidth(125);
                    buttonTop.setMaxWidth(125);
                    buttonTop.setPrefWidth(125);
                    buttonTop.setMinHeight(125);
                    buttonTop.setMaxHeight(125);
                    buttonTop.setPrefHeight(125);


                    buttonTop.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Top Clothing");
                        lblShowName.setText(tempTopCloth.getName());
                        lblShowBrand.setText(tempTopCloth.getBrand());
                        lblShowColor.setText(tempTopCloth.getColor());
                        lblCatOrMat.setText("Category:");
                        lblShowCatOrMat.setText(tempTopCloth.getCategory());
                    });

                    showTopGrid.add(buttonTop, i, 0);
                    setGridMargins(buttonTop);
                }
            }

            for (int i = 0; i < tempBot1.length; i++){
                if (tempBot1[i] != null) {
                    outfits[0].setBotCloth(clothes.get(tempBot1[i]), i);
                    Clothing tempBotCloth = outfits[0].getBotClothes(i);
                    ItemButton botItemButton = new ItemButton(new ImageView(tempBotCloth.getImage()),
                            tempBotCloth.getName());
                    botItemButton.setImageViewSize(100, 100);
                    Button buttonBot = botItemButton.getButton();
                    buttonBot.setMinWidth(125);
                    buttonBot.setMaxWidth(125);
                    buttonBot.setPrefWidth(125);
                    buttonBot.setMinHeight(125);
                    buttonBot.setMaxHeight(125);
                    buttonBot.setPrefHeight(125);


                    buttonBot.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Bot Clothing");
                        lblShowName.setText(tempBotCloth.getName());
                        lblShowBrand.setText(tempBotCloth.getBrand());
                        lblShowColor.setText(tempBotCloth.getColor());
                        lblCatOrMat.setText("Category:");
                        lblShowCatOrMat.setText(tempBotCloth.getCategory());
                    });

                    showBotGrid.add(buttonBot, i, 0);
                    setGridMargins(buttonBot);
                }
            }

            for (int i = 0; i < tempFoot1.length; i++){
                if (tempFoot1[i] != null) {
                    outfits[0].setFootwears(footwears.get(tempFoot1[i]), i);
                    Footwear tempFoot = outfits[0].getFootwears(i);
                    ItemButton footItemButton = new ItemButton(new ImageView(tempFoot.getImage()),
                            tempFoot.getName());
                    footItemButton.setImageViewSize(100, 100);
                    Button buttonFoot = footItemButton.getButton();
                    buttonFoot.setMinWidth(125);
                    buttonFoot.setMaxWidth(125);
                    buttonFoot.setPrefWidth(125);
                    buttonFoot.setMinHeight(125);
                    buttonFoot.setMaxHeight(125);
                    buttonFoot.setPrefHeight(125);


                    buttonFoot.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Footwear");
                        lblShowName.setText(tempFoot.getName());
                        lblShowBrand.setText(tempFoot.getBrand());
                        lblShowColor.setText(tempFoot.getColor());
                        lblCatOrMat.setText("Category:");
                        lblShowCatOrMat.setText(tempFoot.getCategory());
                    });

                    showFootGrid.add(buttonFoot, i, 0);
                    setGridMargins(buttonFoot);
                }
            }
        }
    }

    @FXML
    protected void outfit2Clicked() {
        currOutfitClicked = 1;

        if (outfits[1] != null) {
            showOutfitItems.setVisible(true);
            for (int i = 0; i < tempHead2.length; i++){
                if (tempHead2[i] != null) {
                    outfits[1].setHeadAcc(accessories.get(tempHead2[i]), i);
                    Accessories tempHeadAcc = outfits[1].getHeadAcc(i);
                    ItemButton headItemButton = new ItemButton(new ImageView(tempHeadAcc.getImage()),
                                tempHeadAcc.getName());
                    headItemButton.setImageViewSize(100, 100);
                    Button buttonHead = headItemButton.getButton();
                    buttonHead.setMinWidth(125);
                    buttonHead.setMaxWidth(125);
                    buttonHead.setPrefWidth(125);
                    buttonHead.setMinHeight(125);
                    buttonHead.setMaxHeight(125);
                    buttonHead.setPrefHeight(125);

                    buttonHead.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Head Accessory");
                        lblShowName.setText(tempHeadAcc.getName());
                        lblShowBrand.setText(tempHeadAcc.getBrand());
                        lblShowColor.setText(tempHeadAcc.getColor());
                        lblCatOrMat.setText("Material");
                        lblShowCatOrMat.setText(tempHeadAcc.getCategory());
                    });

                    showHeadGrid.add(buttonHead, i, 0);
                    setGridMargins(buttonHead);
                }
            }

            for (int i = 0; i < tempNeck2.length; i++){
                if (tempNeck2[i] != null) {
                    outfits[1].setNeckAcc(accessories.get(tempNeck2[i]), i);
                    Accessories tempNeckAcc = outfits[1].getNeckAcc(i);
                    ItemButton neckItemButton = new ItemButton(new ImageView(tempNeckAcc.getImage()),
                            tempNeckAcc.getName());
                    neckItemButton.setImageViewSize(100, 100);
                    Button buttonNeck = neckItemButton.getButton();
                    buttonNeck.setMinWidth(125);
                    buttonNeck.setMaxWidth(125);
                    buttonNeck.setPrefWidth(125);
                    buttonNeck.setMinHeight(125);
                    buttonNeck.setMaxHeight(125);
                    buttonNeck.setPrefHeight(125);


                    buttonNeck.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Neck Accessory");
                        lblShowName.setText(tempNeckAcc.getName());
                        lblShowBrand.setText(tempNeckAcc.getBrand());
                        lblShowColor.setText(tempNeckAcc.getColor());
                        lblCatOrMat.setText("Material");
                        lblShowCatOrMat.setText(tempNeckAcc.getCategory());
                    });

                    showNeckGrid.add(buttonNeck, i, 0);
                    setGridMargins(buttonNeck);
                }
            }

            for (int i = 0; i < tempHand2.length; i++){
                if (tempHand2[i] != null) {
                    outfits[1].setHandAcc(accessories.get(tempHand2[i]), i);
                    Accessories tempHandAcc = outfits[1].getHandAcc(i);
                    ItemButton handItemButton = new ItemButton(new ImageView(tempHandAcc.getImage()),
                            tempHandAcc.getName());
                    handItemButton.setImageViewSize(100, 100);
                    Button buttonHand = handItemButton.getButton();
                    buttonHand.setMinWidth(125);
                    buttonHand.setMaxWidth(125);
                    buttonHand.setPrefWidth(125);
                    buttonHand.setMinHeight(125);
                    buttonHand.setMaxHeight(125);
                    buttonHand.setPrefHeight(125);


                    buttonHand.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Hand Accessory");
                        lblShowName.setText(tempHandAcc.getName());
                        lblShowBrand.setText(tempHandAcc.getBrand());
                        lblShowColor.setText(tempHandAcc.getColor());
                        lblCatOrMat.setText("Material:");
                        lblShowCatOrMat.setText(tempHandAcc.getCategory());
                    });

                    showHandGrid.add(buttonHand, i, 0);
                    setGridMargins(buttonHand);
                }
            }

            for (int i = 0; i < tempTop2.length; i++){
                if (tempTop2[i] != null) {
                    outfits[1].setTopCloth(clothes.get(tempTop2[i]), i);
                    Clothing tempTopCloth = outfits[1].getTopClothes(i);
                    ItemButton topItemButton = new ItemButton(new ImageView(tempTopCloth.getImage()),
                            tempTopCloth.getName());
                    topItemButton.setImageViewSize(100, 100);
                    Button buttonTop = topItemButton.getButton();
                    buttonTop.setMinWidth(125);
                    buttonTop.setMaxWidth(125);
                    buttonTop.setPrefWidth(125);
                    buttonTop.setMinHeight(125);
                    buttonTop.setMaxHeight(125);
                    buttonTop.setPrefHeight(125);


                    buttonTop.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Top Clothing");
                        lblShowName.setText(tempTopCloth.getName());
                        lblShowBrand.setText(tempTopCloth.getBrand());
                        lblShowColor.setText(tempTopCloth.getColor());
                        lblCatOrMat.setText("Category:");
                        lblShowCatOrMat.setText(tempTopCloth.getCategory());
                    });

                    showTopGrid.add(buttonTop, i, 0);
                    setGridMargins(buttonTop);
                }
            }

            for (int i = 0; i < tempBot2.length; i++){
                if (tempBot2[i] != null) {
                    outfits[1].setBotCloth(clothes.get(tempBot2[i]), i);
                    Clothing tempBotCloth = outfits[1].getBotClothes(i);
                    ItemButton botItemButton = new ItemButton(new ImageView(tempBotCloth.getImage()),
                            tempBotCloth.getName());
                    botItemButton.setImageViewSize(100, 100);
                    Button buttonBot = botItemButton.getButton();
                    buttonBot.setMinWidth(125);
                    buttonBot.setMaxWidth(125);
                    buttonBot.setPrefWidth(125);
                    buttonBot.setMinHeight(125);
                    buttonBot.setMaxHeight(125);
                    buttonBot.setPrefHeight(125);


                    buttonBot.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Bot Clothing");
                        lblShowName.setText(tempBotCloth.getName());
                        lblShowBrand.setText(tempBotCloth.getBrand());
                        lblShowColor.setText(tempBotCloth.getColor());
                        lblCatOrMat.setText("Category:");
                        lblShowCatOrMat.setText(tempBotCloth.getCategory());
                    });

                    showBotGrid.add(buttonBot, i, 0);
                    setGridMargins(buttonBot);
                }
            }

            for (int i = 0; i < tempFoot2.length; i++){
                if (tempFoot2[i] != null) {
                    outfits[1].setFootwears(footwears.get(tempFoot2[i]), i);
                    Footwear tempFoot = outfits[1].getFootwears(i);
                    ItemButton footItemButton = new ItemButton(new ImageView(tempFoot.getImage()),
                            tempFoot.getName());
                    footItemButton.setImageViewSize(100, 100);
                    Button buttonFoot = footItemButton.getButton();
                    buttonFoot.setMinWidth(125);
                    buttonFoot.setMaxWidth(125);
                    buttonFoot.setPrefWidth(125);
                    buttonFoot.setMinHeight(125);
                    buttonFoot.setMaxHeight(125);
                    buttonFoot.setPrefHeight(125);


                    buttonFoot.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Footwear");
                        lblShowName.setText(tempFoot.getName());
                        lblShowBrand.setText(tempFoot.getBrand());
                        lblShowColor.setText(tempFoot.getColor());
                        lblCatOrMat.setText("Category:");
                        lblShowCatOrMat.setText(tempFoot.getCategory());
                    });

                    showFootGrid.add(buttonFoot, i, 0);
                    setGridMargins(buttonFoot);
                }
            }
        }
    }

    @FXML
    protected void outfit3Clicked() {
        currOutfitClicked = 2;

        if (outfits[2] != null) {
            showOutfitItems.setVisible(true);

            for (int i = 0; i < tempHead3.length; i++){
                if (tempHead3[i] != null) {
                    outfits[2].setHeadAcc(accessories.get(tempHead3[i]), i);
                    Accessories tempHeadAcc = outfits[2].getHeadAcc(i);
                    ItemButton headItemButton = new ItemButton(new ImageView(tempHeadAcc.getImage()),
                                tempHeadAcc.getName());
                    headItemButton.setImageViewSize(100, 100);
                    Button buttonHead = headItemButton.getButton();
                    buttonHead.setMinWidth(125);
                    buttonHead.setMaxWidth(125);
                    buttonHead.setPrefWidth(125);
                    buttonHead.setMinHeight(125);
                    buttonHead.setMaxHeight(125);
                    buttonHead.setPrefHeight(125);


                    buttonHead.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Head Accessory");
                        lblShowName.setText(tempHeadAcc.getName());
                        lblShowBrand.setText(tempHeadAcc.getBrand());
                        lblShowColor.setText(tempHeadAcc.getColor());
                        lblCatOrMat.setText("Material");
                        lblShowCatOrMat.setText(tempHeadAcc.getCategory());
                    });

                    showHeadGrid.add(buttonHead, i, 0);
                    setGridMargins(buttonHead);
                }
            }

            for (int i = 0; i < tempNeck3.length; i++){
                if (tempNeck3[i] != null) {
                    outfits[2].setNeckAcc(accessories.get(tempNeck3[i]), i);
                    Accessories tempNeckAcc = outfits[2].getNeckAcc(i);
                    ItemButton neckItemButton = new ItemButton(new ImageView(tempNeckAcc.getImage()),
                            tempNeckAcc.getName());
                    neckItemButton.setImageViewSize(100, 100);
                    Button buttonNeck = neckItemButton.getButton();
                    buttonNeck.setMinWidth(125);
                    buttonNeck.setMaxWidth(125);
                    buttonNeck.setPrefWidth(125);
                    buttonNeck.setMinHeight(125);
                    buttonNeck.setMaxHeight(125);
                    buttonNeck.setPrefHeight(125);


                    buttonNeck.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Neck Accessory");
                        lblShowName.setText(tempNeckAcc.getName());
                        lblShowBrand.setText(tempNeckAcc.getBrand());
                        lblShowColor.setText(tempNeckAcc.getColor());
                        lblCatOrMat.setText("Material");
                        lblShowCatOrMat.setText(tempNeckAcc.getCategory());
                    });

                    showNeckGrid.add(buttonNeck, i, 0);
                    setGridMargins(buttonNeck);
                }
            }

            for (int i = 0; i < tempHand3.length; i++){
                if (tempHand3[i] != null) {
                    outfits[2].setHandAcc(accessories.get(tempHand3[i]), i);
                    Accessories tempHandAcc = outfits[2].getHandAcc(i);
                    ItemButton handItemButton = new ItemButton(new ImageView(tempHandAcc.getImage()),
                            tempHandAcc.getName());
                    handItemButton.setImageViewSize(100, 100);
                    Button buttonHand = handItemButton.getButton();
                    buttonHand.setMinWidth(125);
                    buttonHand.setMaxWidth(125);
                    buttonHand.setPrefWidth(125);
                    buttonHand.setMinHeight(125);
                    buttonHand.setMaxHeight(125);
                    buttonHand.setPrefHeight(125);


                    buttonHand.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Hand Accessory");
                        lblShowName.setText(tempHandAcc.getName());
                        lblShowBrand.setText(tempHandAcc.getBrand());
                        lblShowColor.setText(tempHandAcc.getColor());
                        lblCatOrMat.setText("Material:");
                        lblShowCatOrMat.setText(tempHandAcc.getCategory());
                    });

                    showHandGrid.add(buttonHand, i, 0);
                    setGridMargins(buttonHand);
                }
            }

            for (int i = 0; i < tempTop3.length; i++){
                if (tempTop3[i] != null) {
                    outfits[2].setTopCloth(clothes.get(tempTop3[i]), i);
                    Clothing tempTopCloth = outfits[2].getTopClothes(i);
                    ItemButton topItemButton = new ItemButton(new ImageView(tempTopCloth.getImage()),
                            tempTopCloth.getName());
                    topItemButton.setImageViewSize(100, 100);
                    Button buttonTop = topItemButton.getButton();
                    buttonTop.setMinWidth(125);
                    buttonTop.setMaxWidth(125);
                    buttonTop.setPrefWidth(125);
                    buttonTop.setMinHeight(125);
                    buttonTop.setMaxHeight(125);
                    buttonTop.setPrefHeight(125);


                    buttonTop.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Top Clothing");
                        lblShowName.setText(tempTopCloth.getName());
                        lblShowBrand.setText(tempTopCloth.getBrand());
                        lblShowColor.setText(tempTopCloth.getColor());
                        lblCatOrMat.setText("Category:");
                        lblShowCatOrMat.setText(tempTopCloth.getCategory());
                    });

                    showTopGrid.add(buttonTop, i, 0);
                    setGridMargins(buttonTop);
                }
            }

            for (int i = 0; i < tempBot3.length; i++){
                if (tempBot3[i] != null) {
                    outfits[2].setBotCloth(clothes.get(tempBot3[i]), i);
                    Clothing tempBotCloth = outfits[2].getBotClothes(i);
                    ItemButton botItemButton = new ItemButton(new ImageView(tempBotCloth.getImage()),
                            tempBotCloth.getName());
                    botItemButton.setImageViewSize(100, 100);
                    Button buttonBot = botItemButton.getButton();
                    buttonBot.setMinWidth(125);
                    buttonBot.setMaxWidth(125);
                    buttonBot.setPrefWidth(125);
                    buttonBot.setMinHeight(125);
                    buttonBot.setMaxHeight(125);
                    buttonBot.setPrefHeight(125);


                    buttonBot.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Bot Clothing");
                        lblShowName.setText(tempBotCloth.getName());
                        lblShowBrand.setText(tempBotCloth.getBrand());
                        lblShowColor.setText(tempBotCloth.getColor());
                        lblCatOrMat.setText("Category:");
                        lblShowCatOrMat.setText(tempBotCloth.getCategory());
                    });

                    showBotGrid.add(buttonBot, i, 0);
                    setGridMargins(buttonBot);
                }
            }

            for (int i = 0; i < tempFoot3.length; i++){
                if (tempFoot3[i] != null) {
                    outfits[2].setFootwears(footwears.get(tempFoot3[i]), i);
                    Footwear tempFoot = outfits[2].getFootwears(i);
                    ItemButton footItemButton = new ItemButton(new ImageView(tempFoot.getImage()),
                            tempFoot.getName());
                    footItemButton.setImageViewSize(100, 100);
                    Button buttonFoot = footItemButton.getButton();
                    buttonFoot.setMinWidth(125);
                    buttonFoot.setMaxWidth(125);
                    buttonFoot.setPrefWidth(125);
                    buttonFoot.setMinHeight(125);
                    buttonFoot.setMaxHeight(125);
                    buttonFoot.setPrefHeight(125);


                    buttonFoot.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Footwear");
                        lblShowName.setText(tempFoot.getName());
                        lblShowBrand.setText(tempFoot.getBrand());
                        lblShowColor.setText(tempFoot.getColor());
                        lblCatOrMat.setText("Category:");
                        lblShowCatOrMat.setText(tempFoot.getCategory());
                    });

                    showFootGrid.add(buttonFoot, i, 0);
                    setGridMargins(buttonFoot);
                }
            }
        }
    }

    @FXML
    protected void outfit4Clicked() {
        currOutfitClicked = 3;

        if (outfits[3] != null) {
            showOutfitItems.setVisible(true);

            for (int i = 0; i < tempHead4.length; i++){
                if (tempHead4[i] != null) {
                    outfits[3].setHeadAcc(accessories.get(tempHead4[i]), i);
                    Accessories tempHeadAcc = outfits[3].getHeadAcc(i);
                    ItemButton headItemButton = new ItemButton(new ImageView(tempHeadAcc.getImage()),
                                tempHeadAcc.getName());
                    headItemButton.setImageViewSize(100, 100);
                    Button buttonHead = headItemButton.getButton();
                    buttonHead.setMinWidth(125);
                    buttonHead.setMaxWidth(125);
                    buttonHead.setPrefWidth(125);
                    buttonHead.setMinHeight(125);
                    buttonHead.setMaxHeight(125);
                    buttonHead.setPrefHeight(125);


                    buttonHead.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Head Accessory");
                        lblShowName.setText(tempHeadAcc.getName());
                        lblShowBrand.setText(tempHeadAcc.getBrand());
                        lblShowColor.setText(tempHeadAcc.getColor());
                        lblCatOrMat.setText("Material");
                        lblShowCatOrMat.setText(tempHeadAcc.getCategory());
                    });

                    showHeadGrid.add(buttonHead, i, 0);
                    setGridMargins(buttonHead);
                }
            }

            for (int i = 0; i < tempNeck4.length; i++){
                if (tempNeck4[i] != null) {
                    outfits[3].setNeckAcc(accessories.get(tempNeck4[i]), i);
                    Accessories tempNeckAcc = outfits[3].getNeckAcc(i);
                    ItemButton neckItemButton = new ItemButton(new ImageView(tempNeckAcc.getImage()),
                            tempNeckAcc.getName());
                    neckItemButton.setImageViewSize(100, 100);
                    Button buttonNeck = neckItemButton.getButton();
                    buttonNeck.setMinWidth(125);
                    buttonNeck.setMaxWidth(125);
                    buttonNeck.setPrefWidth(125);
                    buttonNeck.setMinHeight(125);
                    buttonNeck.setMaxHeight(125);
                    buttonNeck.setPrefHeight(125);


                    buttonNeck.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Neck Accessory");
                        lblShowName.setText(tempNeckAcc.getName());
                        lblShowBrand.setText(tempNeckAcc.getBrand());
                        lblShowColor.setText(tempNeckAcc.getColor());
                        lblCatOrMat.setText("Material");
                        lblShowCatOrMat.setText(tempNeckAcc.getCategory());
                    });

                    showNeckGrid.add(buttonNeck, i, 0);
                    setGridMargins(buttonNeck);
                }
            }

            for (int i = 0; i < tempHand4.length; i++){
                if (tempHand4[i] != null) {
                    outfits[3].setHandAcc(accessories.get(tempHand4[i]), i);
                    Accessories tempHandAcc = outfits[3].getHandAcc(i);
                    ItemButton handItemButton = new ItemButton(new ImageView(tempHandAcc.getImage()),
                            tempHandAcc.getName());
                    handItemButton.setImageViewSize(100, 100);
                    Button buttonHand = handItemButton.getButton();
                    buttonHand.setMinWidth(125);
                    buttonHand.setMaxWidth(125);
                    buttonHand.setPrefWidth(125);
                    buttonHand.setMinHeight(125);
                    buttonHand.setMaxHeight(125);
                    buttonHand.setPrefHeight(125);


                    buttonHand.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Hand Accessory");
                        lblShowName.setText(tempHandAcc.getName());
                        lblShowBrand.setText(tempHandAcc.getBrand());
                        lblShowColor.setText(tempHandAcc.getColor());
                        lblCatOrMat.setText("Material:");
                        lblShowCatOrMat.setText(tempHandAcc.getCategory());
                    });

                    showHandGrid.add(buttonHand, i, 0);
                    setGridMargins(buttonHand);
                }
            }

            for (int i = 0; i < tempTop4.length; i++){
                if (tempTop4[i] != null) {
                    outfits[3].setTopCloth(clothes.get(tempTop4[i]), i);
                    Clothing tempTopCloth = outfits[3].getTopClothes(i);
                    ItemButton topItemButton = new ItemButton(new ImageView(tempTopCloth.getImage()),
                            tempTopCloth.getName());
                    topItemButton.setImageViewSize(100, 100);
                    Button buttonTop = topItemButton.getButton();
                    buttonTop.setMinWidth(125);
                    buttonTop.setMaxWidth(125);
                    buttonTop.setPrefWidth(125);
                    buttonTop.setMinHeight(125);
                    buttonTop.setMaxHeight(125);
                    buttonTop.setPrefHeight(125);


                    buttonTop.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Top Clothing");
                        lblShowName.setText(tempTopCloth.getName());
                        lblShowBrand.setText(tempTopCloth.getBrand());
                        lblShowColor.setText(tempTopCloth.getColor());
                        lblCatOrMat.setText("Category:");
                        lblShowCatOrMat.setText(tempTopCloth.getCategory());
                    });

                    showTopGrid.add(buttonTop, i, 0);
                    setGridMargins(buttonTop);
                }
            }

            for (int i = 0; i < tempBot4.length; i++){
                if (tempBot4[i] != null) {
                    outfits[3].setBotCloth(clothes.get(tempBot4[i]), i);
                    Clothing tempBotCloth = outfits[3].getBotClothes(i);
                    ItemButton botItemButton = new ItemButton(new ImageView(tempBotCloth.getImage()),
                            tempBotCloth.getName());
                    botItemButton.setImageViewSize(100, 100);
                    Button buttonBot = botItemButton.getButton();
                    buttonBot.setMinWidth(125);
                    buttonBot.setMaxWidth(125);
                    buttonBot.setPrefWidth(125);
                    buttonBot.setMinHeight(125);
                    buttonBot.setMaxHeight(125);
                    buttonBot.setPrefHeight(125);


                    buttonBot.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Bot Clothing");
                        lblShowName.setText(tempBotCloth.getName());
                        lblShowBrand.setText(tempBotCloth.getBrand());
                        lblShowColor.setText(tempBotCloth.getColor());
                        lblCatOrMat.setText("Category:");
                        lblShowCatOrMat.setText(tempBotCloth.getCategory());
                    });

                    showBotGrid.add(buttonBot, i, 0);
                    setGridMargins(buttonBot);
                }
            }

            for (int i = 0; i < tempFoot4.length; i++){
                if (tempFoot4[i] != null) {
                    outfits[3].setFootwears(footwears.get(tempFoot4[i]), i);
                    Footwear tempFoot = outfits[3].getFootwears(i);
                    ItemButton footItemButton = new ItemButton(new ImageView(tempFoot.getImage()),
                            tempFoot.getName());
                    footItemButton.setImageViewSize(100, 100);
                    Button buttonFoot = footItemButton.getButton();
                    buttonFoot.setMinWidth(125);
                    buttonFoot.setMaxWidth(125);
                    buttonFoot.setPrefWidth(125);
                    buttonFoot.setMinHeight(125);
                    buttonFoot.setMaxHeight(125);
                    buttonFoot.setPrefHeight(125);


                    buttonFoot.setOnAction(e -> {
                        showInfoPane.setVisible(true);
                        lblShowItem.setText("Footwear");
                        lblShowName.setText(tempFoot.getName());
                        lblShowBrand.setText(tempFoot.getBrand());
                        lblShowColor.setText(tempFoot.getColor());
                        lblCatOrMat.setText("Category:");
                        lblShowCatOrMat.setText(tempFoot.getCategory());
                    });

                    showFootGrid.add(buttonFoot, i, 0);
                    setGridMargins(buttonFoot);
                }
            }
        }
    }

    @FXML
    protected void btnRemoveOutfit() {
        showOutfitItems.setVisible(false);

        switch (currOutfitClicked) {
            case 0 :

                tempHead1 = new String[2];
                tempNeck1 = new String[2];
                tempHand1 = new String[2];
                tempTop1 = new String[2];
                tempBot1 = new String[2];
                tempFoot1 = new String[2];

                outfits[0] = null;

                btnOpt1.setDisable(false);

                break;

            case 1 :
                tempHead2 = new String[2];
                tempNeck2 = new String[2];
                tempHand2 = new String[2];
                tempTop2 = new String[2];
                tempBot2 = new String[2];
                tempFoot2 = new String[2];

                outfits[1] = null;

                btnOpt2.setDisable(false);
                break;

            case 2 :
                tempHead3 = new String[2];
                tempNeck3 = new String[2];
                tempHand3 = new String[2];
                tempTop3 = new String[2];
                tempBot3 = new String[2];
                tempFoot3 = new String[2];

                outfits[2] = null;

                btnOpt3.setDisable(false);
                break;

            case 3 :
                tempHead4 = new String[2];
                tempNeck4 = new String[2];
                tempHand4 = new String[2];
                tempTop4 = new String[2];
                tempBot4 = new String[2];
                tempFoot4 = new String[2];

                outfits[3] = null;

                btnOpt4.setDisable(false);
                break;
        }
    }





    // ---------- Show Outfits Creation END ----------




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
