package com.wardrobemanagementsystem;

public class Accessories extends Item {
    private String location, category; // Neck, Ear, Arm, etc

    public enum categories {
        WATCH, NECKLACE, EARRING, BRACELET, HEADWEAR, GLASSES, RING
    }

    public enum locations {
        NECK, HEAD, HAND
    }

    void setLocation(String location) {
        this.location = location;
    }

    String getLocation() {
        return location;
    }

}


