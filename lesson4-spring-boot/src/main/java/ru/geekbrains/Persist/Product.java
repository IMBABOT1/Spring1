package ru.geekbrains.Persist;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Product {

    private Long id;
    private String title;

    private int minPrice;

    private int maxPrice;

    public Product(Long id, String title, int minPrice, int maxPrice) {
        this.id = id;
        this.title = title;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public Product(){

    }

    @Override
    public String toString() {
        return id + " " + title + " " + minPrice + " " + maxPrice;
    }

}