package com.wardrobemanagementsystem;

public class Accessories extends Item {
    private String category;

    public enum HeadMaterialsCategory {
        LEATHER("Leather"),
        METAL("Metal"),
        FABRIC("Fabric"),
        PLASTIC("Plastic");

        private final String displayName;

        HeadMaterialsCategory (String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum NeckMaterialsCategory {
        GEMSTONES("Gemstones"),
        METAL("Metal"),
        PLASTIC("Plastic"),
        FABRIC("Fabric"),
        WOOD("Wood");

        private final String displayName;

        NeckMaterialsCategory (String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum HandMaterialsCategory {
        GEMSTONES("Gemstones"),
        METAL("Metal"),
        PLASTIC("Plastic"),
        FABRIC("Fabric"),
        WOOD("Wood");

        private final String displayName;

        HandMaterialsCategory (String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public void setCategory (String category) {
        this.category = category;
    }

    public String getCategory () {
        return category;
    }

}



