package com.wardrobemanagementsystem;

public class Clothing extends Item {
    private String type, category, size; // type: top or bottom and category: shirt, dress, suit, etc...

    public enum sizes{
        XS, S, M, L, XL,
    }

    public enum type {
        TOP, BOTTOM
    }

    public enum category {
        SHIRT, DRESS, PANTS, SKIRT, TANKTOP, LONGSLEEVE
    }

    void setType(String type) {
        this.type = type;
    }

    void setCategory(String category) {
        this.category = category;
    }

    void setSize(String size) {
        this.size = size;
    }

    String getType() {
        return type;
    }

    String getCategory() {
        return category;
    }

    String getSize() {
        return size;
    }


}

