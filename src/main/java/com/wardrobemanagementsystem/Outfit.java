package com.wardrobemanagementsystem;

public class Outfit {
    private Clothing[] topClothes = new Clothing[2];
    private Clothing[] botClothes = new Clothing[2];

    private Accessories[] headAcc = new Accessories[2];
    private Accessories[] neckAcc = new Accessories[2];
    private Accessories[] handAcc = new Accessories[2];


    public Footwear[] footwears = new Footwear[2];

    public void setTopCloth(Clothing clothes, int index) {
        this.topClothes[index] = clothes;
    }

    public void setBotCloth(Clothing clothes, int index) {
        this.botClothes[index] = clothes;
    }

    public void setHeadAcc(Accessories accessories, int index) {
        this.headAcc[index] = accessories;
    }

    public void setNeckAcc(Accessories accessories, int index) {
        this.neckAcc[index] = accessories;
    }

    public void setHandAcc(Accessories accessories, int index) {
        this.handAcc[index] = accessories;
    }

    public void setFootwears(Footwear footwears, int index) {
        this.footwears[index] = footwears;
    }

    public Clothing getTopClothes(int index) {
        return topClothes[index];
    }

    public Clothing getBotClothes(int index) {
        return botClothes[index];
    }

    public Accessories getHeadAcc(int index) {
        return headAcc[index];
    }

    public Accessories getNeckAcc(int index) {
        return neckAcc[index];
    }

    public Accessories getHandAcc(int index) {
        return handAcc[index];
    }

    public Footwear getFootwears(int index) {
        return footwears[index];
    }

    public void removeTopClothes(int index) {
        this.topClothes[index] = null;
    }

    public void removeBotClothes(int index) {
        this.botClothes[index] = null;
    }

    public void removeHeadAcc(int index) {
        this.headAcc[index] = null;
    }

    public void removeNeckAcc(int index) {
        this.neckAcc[index] = null;
    }

    public void removeHandAcc(int index) {
        this.handAcc[index] = null;
    }

    public void removeFootwears(int index) {
        this.footwears[index] = null;
    }

}










