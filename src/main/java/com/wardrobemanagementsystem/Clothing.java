package com.wardrobemanagementsystem;

public class Clothing extends Item {
    private String type, category, size; // type: top or bottom and category: shirt, dress, suit, etc...

    public enum sizes{
        XS, S, M, L, XL,
    }

    public enum type {
        TOP, BOTTOM
    }

    public enum TopCategories {
        SHIRT("Shirt"),
        DRESS("Dress"),
        TANKTOP("Tank Top"),
        LONGSLEEVE("Long Sleeve");

        private final String displayName;

        TopCategories(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }

    }
     public enum BottomCategories {
        PANTS("Pants"),
        SKIRT("Skirt"),
        SHORTS("Shorts");

        private final String displayName;

        BottomCategories(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
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

    String getCategoryName() {
        return category;
    }
}

