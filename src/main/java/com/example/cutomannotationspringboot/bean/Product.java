package com.example.cutomannotationspringboot.bean;

import com.example.cutomannotationspringboot.annotation.TamLength;
import com.example.cutomannotationspringboot.annotation.TamNotNull;
import com.example.cutomannotationspringboot.annotation.TamRange;

public class Product {
    @TamNotNull
    private String name;

    @TamRange(min = 2000, max = 5000)
    private int price;

    @TamLength(min = 1, max = 5)
    private String category;

    public Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
