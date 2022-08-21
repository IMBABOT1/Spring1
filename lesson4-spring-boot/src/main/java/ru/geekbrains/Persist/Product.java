package ru.geekbrains.Persist;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Product {

    private Long id;
    private String title;
    private int price;

    public Product(Long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Product(){

    }

    @Override
    public String toString() {
        return id + " " + title + " " + price;
    }

}