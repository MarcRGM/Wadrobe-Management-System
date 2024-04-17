package com.wardrobemanagementsystem;

public class Footwear extends Item{
    private String category; // Rubber shoes, heels, etc..
    private int inchSize;

    public enum categories {
        SNEAKERS, BOOTS, SANDALS, HEELS, SLIPPERS, SOCKS
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


