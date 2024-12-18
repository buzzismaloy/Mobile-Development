package com.example.lab5;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Product implements Serializable {
    String name;
    String description;
    double price;
    int imageResourceId;

    public Product(String name, String description, double price, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public int getImage() {
        return this.imageResourceId;
    }
}
