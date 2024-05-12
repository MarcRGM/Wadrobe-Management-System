package com.wardrobemanagementsystem;

import javafx.scene.image.Image;

public class Item {

    private String name, brand, color;
    Image image;

    void setImage(Image image) {
        this.image = image;
    }

    Image getImage() {
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


    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }


}











