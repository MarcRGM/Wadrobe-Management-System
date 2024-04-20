package com.wardrobemanagementsystem;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;

public class Item {

    private String name, brand, color, situation, gender;
    Image image;

    public enum genders { // Who can use the item
        MALE, FEMALE, UNISEX
    }

    public enum situations {
        CASUAL, FORMAL, SPORTS, PARTY
    }

    Image setImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            image = new Image(selectedFile.toURI().toString());
            // imageChange.setImage(image);
        }

        return image;
    }


    void setName(String name) {
        this.name = name;
    }

    void setBrand(String brand) {
        this.brand = brand;
    }

    void setColor(String color) {
        this.color = color;
    }

    void setSituation(String situation) {
        this.situation = situation;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getSituation() {
        return situation;
    }


}

