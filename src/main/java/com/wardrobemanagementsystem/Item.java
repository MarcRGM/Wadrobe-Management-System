package com.wardrobemanagementsystem;

public class Item {

    private String name, brand, color, situation, gender;

    public enum genders { // Who can use the item
        MALE, FEMALE, UNISEX
    }

    public enum situations {
        CASUAL, FORMAL, SPORTS, PARTY
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

