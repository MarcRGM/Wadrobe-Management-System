package com.wardrobemanagementsystem;

public class Clothing extends Item {
    private String category;

    public enum sizes{
        XS, S, M, L, XL,
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

    public void setCategory(String category) {
            this.category = category;
    }

    public String getCategory() {
        return category;
    }


}



