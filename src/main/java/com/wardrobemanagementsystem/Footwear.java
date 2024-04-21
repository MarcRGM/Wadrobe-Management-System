package com.wardrobemanagementsystem;

public class Footwear extends Item{
    private String category; // Rubber shoes, heels, etc..
    private int inchSize;

    public enum Categories {
        SNEAKERS("Sneakers"),
        BOOTS("Boots"),
        SANDALS("Sandals"),
        HEELS("Heels"),
        SLIPPERS("Slippers");

        private final String displayName;

        Categories(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }

    }


    void setCategory(String category) {
        this.category = category;
    }

    void setInchSize(int inchSize) {
        this.inchSize = inchSize;
    }

    String getCategory() {
        return category;
    }

    int getInchSize() {
        return inchSize;
    }

}


