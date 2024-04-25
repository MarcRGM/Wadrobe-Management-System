package com.wardrobemanagementsystem;

public class Footwear extends Item{
    private String category;

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

    public void setCategory(String category) {
            this.category = category;
    }

    public String getCategory() {
        return category;
    }

}


