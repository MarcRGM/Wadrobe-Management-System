package com.wardrobemanagementsystem;

public class Outfits {
    private Clothing[] clothes = new Clothing[2];
    private Accessories[] accessories = new Accessories[2];
    public Footwear[] footwears = new Footwear[2];

    public void setClothes(Clothing[] clothes) {
        this.clothes = clothes;
    }

    public void setAccessories(Accessories[] accessories) {
        this.accessories = accessories;
    }

    public void setFootwears(Footwear[] footwears) {
        this.footwears = footwears;
    }

    
}
