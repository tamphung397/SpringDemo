package com.example.cutomannotationspringboot.bean;

import com.example.cutomannotationspringboot.annotation.TamLength;
import com.example.cutomannotationspringboot.annotation.TamNotNull;
import com.example.cutomannotationspringboot.annotation.TamRange;
import lombok.Data;

@Data
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
}
