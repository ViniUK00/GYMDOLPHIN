package com.example.gymdolphin;

public class ItemModel {
    private String image;
    private String name;
    private String smallDescription;
    private String bigDescription;
    private int stockCount;
    private double price;

    public ItemModel() {
        // Default constructor required for Firebase
    }

    public ItemModel(String image, String name, String smallDescription, String bigDescription, int stockCount, double price) {
        this.image = image;
        this.name = name;
        this.smallDescription = smallDescription;
        this.bigDescription = bigDescription;
        this.stockCount = stockCount;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public String getBigDescription() {
        return bigDescription;
    }

    public int getStockCount() {
        return stockCount;
    }

    public double getPrice() {
        return price;
    }
}
