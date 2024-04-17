package com.wardrobemanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class WardrobeGUI extends Application {

    // HashMap is an unordered collection that stores elements in key-value pairs <Key, Value>,
    // allowing us to access them using a key.
    // The keys in a HashMap must be unique, while values can be duplicated.
    // HashMap is useful when we need to store a collection of objects that can be accessed efficiently using a key,
    // instead of an index.
    private HashMap<String, Clothing> clothes = new HashMap<>();
    private HashMap<String, Accessories> accessors = new HashMap<>();
    private HashMap<String, Footwear> footwears = new HashMap<>();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WardrobeGUI.class.getResource("wardrobe.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wardrobe Management System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // Create Outfits

    // Add items

    // Remove items

    // Search items

    // Select an event for an item

    // Show ALL tab

    // Show Clothing tab

    // Show Footwear Tab


}
