package com.example.gymdolphin;

public class CartItemModel {

    private String imageUrl;
    private String name;
    private double price;
    private String username;
    private int quantity;

    // Default constructor required for Firestore
    public CartItemModel() {
        // Empty constructor needed for Firestore
    }

    // Constructor for creating a new cart item
    public CartItemModel(String imageUrl, double price, String name, String username, int quantity) {
        this.imageUrl = imageUrl;
        this.price = price;
        this.name = name;
        this.username = username;
        this.quantity = quantity;
    }

    // Getter and setter methods

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
